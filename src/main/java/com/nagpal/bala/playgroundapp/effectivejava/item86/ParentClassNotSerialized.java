package com.nagpal.bala.playgroundapp.effectivejava.item86;

import lombok.Getter;
import lombok.Setter;

import java.io.*;

public class ParentClassNotSerialized {

    public static void main(String[] args) throws Exception {
        Child child = new Child();
        String dir = System.getProperty("user.dir");
        try(OutputStream fos = new FileOutputStream(dir + "/child.ser")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println("Serializing child object : " + child);
            oos.writeObject(child);
        }

        try(InputStream fis = new FileInputStream(dir + "/child.ser")) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            Child child1 = (Child) ois.readObject();
            System.out.println("Deserialized d object : " + child1);
        }
    }
}

@Getter
@Setter
class Parent {
    private int val;

    Parent() {
        val = 10;
    }
}

class Child extends Parent implements Serializable {
    private String str;

    Child() {
        str = "Balkrishan";
        setVal(20);
    }

    public String toString() {
        return "Child{" +
                "val=" + getVal() +
                ", str='" + str + '\'' +
                '}';
    }
}
