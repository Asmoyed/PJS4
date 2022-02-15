package com.logic.dto;

import java.io.*;

public class Serializer {
    public static void serialize(Object obj, String path) {
        File file = new File(path);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserialize(String path) {
        File file = new File(path);
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            try {
                return ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
