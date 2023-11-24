package com.nagpal.bala.playgroundapp.effectivejava.item86;

import java.io.*;

public class CustomizeSerialization {

    public static void main(String[] args) throws Exception {
        Customize customize = new Customize();
        String userHome = System.getProperty("user.home");
        try(OutputStream fos = new FileOutputStream(userHome + "/custom.ser")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println("Serializing customize object : " + customize);
            oos.writeObject(customize);
        }

        try(InputStream fis = new FileInputStream(userHome + "/custom.ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            Customize obj = (Customize) ois.readObject();
            System.out.println("Desrializing customize object : " + obj);
            System.out.println("obj = " + obj);
        }
    }

    static class Customize implements Serializable {
        private int val = 5;
        private String str = "Balkrishan";

        private static final ObjectStreamField[] serialPersistentFields = {
                new ObjectStreamField("val", int.class)
        };

        private void readObject(ObjectInputStream in) throws Exception {
            ObjectInputStream.GetField fields = in.readFields();
            val = fields.get("val", 0);
        }

        private void writeObject(ObjectOutputStream out) throws Exception {
            ObjectOutputStream.PutField fields = out.putFields();
            fields.put("val", val);
            out.writeFields();
        }

        public String toString() {
            return "Customize{" +
                    "val=" + val +
                    ", str='" + str + '\'' +
                    '}';
        }
    }
}


