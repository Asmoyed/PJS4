package com.logic.dto.data;

import com.logic.dto.serialization.ObjectNotSerializableException;
import com.logic.dto.serialization.ObjectParsingException;
import com.logic.dto.serialization.Serializer;

import java.util.ArrayList;
import java.util.List;

public class World
{
    private StaticEntity[][] staticEntities;
    private List<Character> characters;

    public World(StaticEntity[][] staticEntities) 
    {
        this.staticEntities = staticEntities;
        this.characters = new ArrayList<Character>();
    }
    
    public StaticEntity[][] getStaticEntities() 
    {
        return staticEntities;
    }
    public List<Character> getCharacters()
    {
        return characters;
    }

    public void setDynamicEntities(List<Character> characters)
    {
        this.characters = characters;
    }
    public void setStaticEntities(StaticEntity[][] staticEntities) 
    {
        this.staticEntities = staticEntities;
    }

    public World copy()
    {
        World copy = new World(this.staticEntities.clone());
        List<Character> characters = new ArrayList<Character>();

        for (Character c : this.characters)
        {
            try
            {
                Character copied = (Character) Serializer.deserializeFromString(Character.class, Serializer.serialize(c));
                copied.setY(c.getY());
                copied.setX(c.getX());
                characters.add(copied);
            }
            catch (Exception e)
            {
                throw new RuntimeException("Erreur de copie");
            }
        }

        copy.characters = characters;
        return copy;
    }

    public void addCharacter(Character character) {
        characters.add(character);
    }
}
