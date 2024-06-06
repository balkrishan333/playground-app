package com.nagpal.bala.playgroundapp.effectivejava;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Item_85 implements Serializable {

    private static final int BOMB_NESTING_LEVEL = 1;
    private static final String PATH_BOMB = "/Users/bnagpal1/temp/item85.bomb";
    private static final String PATH_FILTER = "/Users/bnagpal1/temp/item85.filter";

    public static void main(String[] args) throws Exception {
        implementSerializationBomb();
        implementSerializationFilter();
    }

    private static void implementSerializationFilter() throws Exception {
        Filter_1 filter1 = new Filter_1();
        filter1.name = "bala";
        serialize(filter1, PATH_FILTER + "_1");

        Filter_2 filter2 = new Filter_2();
        filter2.age = 40;
        serialize(filter2, PATH_FILTER + "_2");

        //This filter rejects to deserialize the Filter1 class. Change status to ALLOWED in filter to get Filter1
        // class deserialized
        ObjectInputFilter.Config.setSerialFilter(new SerializationFilter());

        try {
            FileInputStream fis = new FileInputStream(PATH_FILTER + "_1");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object readObject = ois.readObject();
            System.out.println("readObject = " + readObject);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        FileInputStream fis_2 = new FileInputStream(PATH_FILTER + "_2");
        ObjectInputStream ois_2 = new ObjectInputStream(fis_2);
        Object readObject_2 = ois_2.readObject();
        System.out.println("readObject_2 = " + readObject_2);
    }

    private static void implementSerializationBomb() {
        createBomb();
        readBomb();
    }

    static void createBomb() {
        Set<Object> root = new HashSet<>();
        Set<Object> s1 = root;
        Set<Object> s2 = new HashSet<>();
        for (int i = 0; i < BOMB_NESTING_LEVEL; i++) {
            Set<Object> t1 = new HashSet<>();
            Set<Object> t2 = new HashSet<>();
            t1.add("foo"); // Make t1 unequal to t2
            s1.add(t1);
            s1.add(t2);
            s2.add(t1);
            s2.add(t2);
            s1 = t1;
            s2 = t2;
        }
        serialize(root, PATH_BOMB); // Method omitted for brevity
    }

    static void readBomb() {
        File file = new File(PATH_BOMB);
        try {
            InputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            long startTime = System.currentTimeMillis();
            Object root = ois.readObject();
//            System.out.println(root);
            System.out.println("Deserialization time: " + (System.currentTimeMillis() - startTime) + " ms");

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /*
        Serialize objects
     */
    private static void serialize(Object obj, String path) {
        try {
            File file = new File(path);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
        Class for Serialization
     */
    static class Filter_1 implements Serializable {
        private String name;

        @Override
        public String toString() {
            return name;
        }
    }

    /*
        Class for Serialization
     */
    static class Filter_2 implements Serializable {
        private int age;

        private void readObject(ObjectInputStream ois) throws Exception {
            System.out.println("Inside readObject....");
            ObjectInputStream.GetField fields = ois.readFields();
            int streamValue = fields.get("age", -1);
            System.out.println("streamValue = " + streamValue);
            age = 33;
        }

        private void writeObject(ObjectOutputStream oos) throws Exception {
            ObjectOutputStream.PutField putFields = oos.putFields();
            putFields.put("age", age);
            oos.writeFields();
        }
        @Override
        public String toString() {
            return String.valueOf(age);
        }
    }

    /*
        Deserialization Filter
     */
    static class SerializationFilter implements ObjectInputFilter {
        public ObjectInputFilter.Status checkInput(ObjectInputFilter.FilterInfo info) {

            if (info.serialClass() != null &&
                    Filter_1.class.isAssignableFrom(info.serialClass())) {
                return Status.REJECTED;      // Do not allow Remote objects
            }
            return ObjectInputFilter.Status.UNDECIDED;
        }
    }
}
