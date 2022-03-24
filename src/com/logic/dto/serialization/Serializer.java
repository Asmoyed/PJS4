package com.logic.dto.serialization;

import com.logic.dto.data.CharacterState;

import javax.json.*;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Serializer
{
    public static void serialize(Object obj, String path) throws ObjectNotSerializableException, ObjectParsingException
    {
        try
        {
            JsonObjectBuilder builder = buildJson(obj);

            PrintWriter out = new PrintWriter(new FileOutputStream(path));
            out.print(builder.build().toString());
            out.flush();
            out.close();
        }
        catch (IOException e)
        {
            throw new ObjectParsingException("Erreur IO : " + e.getMessage());
        }
    }

    public static String serialize(Object obj) throws ObjectNotSerializableException, ObjectParsingException
    {
        return buildJson(obj).build().toString();
    }

    public static Object deserialize(Class<?> objClass, String path) throws ObjectParsingException
    {
        try
        {
            InputStream fis = new FileInputStream(path);
            JsonObject jObj = Json.createReader(fis).readObject();
            Object result = objClass.getConstructor().newInstance();

            parseJsonIntoObject(result, jObj);

            return result;
        }
        catch (IOException e)
        {
            throw new ObjectParsingException("Erreur IO : " + e.getMessage());
        }
        catch (NoSuchMethodException e)
        {
            throw new ObjectParsingException("Erreur Syntaxe : Constructeur vide non trouvé pour " + objClass.getName());
        }
        catch (Exception e)
        {
            throw new ObjectParsingException("Erreur : " + e.getMessage());
        }
    }

    public static Object deserializeFromString(Class<?> objClass, String content) throws ObjectParsingException
    {
        try
        {
            InputStream fis = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
            JsonObject jObj = Json.createReader(fis).readObject();
            Object result = objClass.getConstructor().newInstance();

            parseJsonIntoObject(result, jObj);

            return result;
        }
        catch (NoSuchMethodException e)
        {
            throw new ObjectParsingException("Erreur Syntaxe : Constructeur vide non trouvé pour " + objClass.getName());
        }
        catch (Exception e)
        {
            throw new ObjectParsingException("Erreur : " + e.getMessage());
        }
    }

    private static String capitalize(String s)
    {
        return java.lang.Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    private static JsonObjectBuilder buildJson(Object obj) throws ObjectNotSerializableException, ObjectParsingException
    {
        JsonObjectBuilder builder = Json.createObjectBuilder();

        for (Field f : obj.getClass().getDeclaredFields())
        {
            try
            {
                Object val = obj.getClass().getMethod("get" + capitalize(f.getName())).invoke(obj);

                if (val == null)
                {
                    builder.add(f.getName(), "null");
                }
                else if (f.getType() == int.class || f.getType() == Integer.class)
                {
                    builder.add(f.getName(), (int) val);
                }
                else if (f.getType() == float.class || f.getType() == Float.class)
                {
                    builder.add(f.getName(), (Float) val);
                }
                else if (f.getType() == String.class)
                {
                    builder.add(f.getName(), (String) val);
                }
                else if (f.getType() == boolean.class ||f.getType() == Boolean.class)
                {
                    builder.add(f.getName(), (Boolean) val);
                }
                else if (f.getType() == double.class ||f.getType() == Double.class)
                {
                    builder.add(f.getName(), (Double) val);
                }
                else // Si ce n'est pas un type json, on fais de la recursivité
                {
                    if (!f.getType().isEnum()) // Eviter d'essayer de serialiser un enum comme une classe
                    {
                        builder.add(f.getName(), buildJson(val));
                    }
                    else // Si c'est un enum
                    {
                        builder.add(f.getName(), val.toString());
                    }
                }
            }
            catch (NoSuchMethodException e)
            {
                throw new ObjectNotSerializableException("L'attribut " + f.getName() + " de " + obj.getClass() + " n'a pas de getter standard !");
            }
            catch (Exception ex)
            {
                throw new ObjectParsingException("Erreur pendant la serialisation : " + ex.getMessage());
            }
        }

        return builder;
    }

    private static void parseJsonIntoObject(Object obj, JsonObject jsonObj) throws ObjectParsingException
    {
        // Pour tous les elements du json on les insère dans les attributs
        Iterator<Map.Entry<String, JsonValue>> it = jsonObj.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<String, JsonValue> entry = it.next();
            parseValIntoField(obj, entry.getKey(), entry.getValue().toString());
        }
    }

    private static void parseValIntoField(Object obj, String name, String val) throws ObjectParsingException
    {
        try
        {
            Class<?> type = obj.getClass().getDeclaredField(name).getType();
            Method setter = obj.getClass().getMethod("set" + capitalize(name), type);
            Object parsedVal = null;

            if (type == int.class || type == Integer.class)
            {
                parsedVal = Integer.parseInt(val);
            }
            else if (type == float.class || type == Float.class)
            {
                parsedVal = Float.parseFloat(val);
            }
            else if (type == String.class)
            {
                parsedVal = val;
            }
            else if (type == boolean.class || type == Boolean.class)
            {
                parsedVal = Boolean.parseBoolean(val);
            }
            else if (type == double.class || type == Double.class)
            {
                parsedVal = Double.parseDouble(val);
            }
            else // on a eu un objet et non une valeur
            {
                if (type.isEnum()) // Si c'est un enum
                {
                    if (!val.equals("null")) // Si l'enum == null alors on ne cherche pas a le cast
                    {
                        parsedVal = type.getMethod("valueOf", String.class).invoke(null, val);
                    }
                }
                else
                {
                    JsonObject jsonObj = Json.createReader(new StringReader(val)).readObject();
                    Object childObj = type.getConstructor().newInstance();
                    parseJsonIntoObject(childObj, jsonObj);
                    parsedVal = childObj;
                }
            }

            setter.invoke(obj, parsedVal); // On défini l'objet
        }
        catch (NoSuchFieldException e)
        {
            throw new ObjectParsingException("Aucun attribut " + name + " dans "+ obj.getClass().getName());
        }
        catch (Exception e)
        {
            throw new ObjectParsingException("Erreur : " + e.getMessage());
        }
    }
}