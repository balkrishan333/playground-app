package com.nagpal.bala.playgroundapp.effectivejava;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Item_85 implements Serializable {

    private static final String PATH = "/Users/bnagpal1/temp/item85.serial";

    public static void main(String[] args) {
        bomb();
        readbomb();
    }

    static void bomb() {
        Set<Object> root = new HashSet<>();
        Set<Object> s1 = root;
        Set<Object> s2 = new HashSet<>();
        for (int i = 0; i < 30; i++) {
            Set<Object> t1 = new HashSet<>();
            Set<Object> t2 = new HashSet<>();
            t1.add("foo"); // Make t1 unequal to t2
            s1.add(t1); s1.add(t2);
            s2.add(t1); s2.add(t2);
            s1 = t1;
            s2 = t2;
        }

        serialize(root); // Method omitted for brevity
    }

    static void readbomb() {
        File file = new File(PATH);
        try {
            InputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            long startTime = System.currentTimeMillis();
            Object root = ois.readObject();
            System.out.println(root);
            System.out.println("Deserialization time: " + (System.currentTimeMillis() - startTime) + " ms");

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void serialize(Set<Object> obj) {
        try {
            File file = new File(PATH);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
