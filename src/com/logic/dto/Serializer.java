package com.logic.dto;

import java.io.*;

public class Serializer<T> {
    public void serialize(Object obj, String path) {
        File file = new File(path);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T deserialize(String path) {
        File file = new File(path);
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            try {
                return (T) ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
