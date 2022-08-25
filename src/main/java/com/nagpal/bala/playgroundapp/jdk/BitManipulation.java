package com.nagpal.bala.playgroundapp.jdk;

public class BitManipulation {

    public static void main(String[] args) {

        find16MSBOfInt(1801317);
    }

    private static void find16MSBOfInt(int num) {
        int mask = 0xFFFF0000;

        int val = num & mask;
        val >>= 16;
        System.out.println("val = " + val);
    }
}
