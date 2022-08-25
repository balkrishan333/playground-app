package com.nagpal.bala.playgroundapp.jdk;

import java.util.BitSet;

public class BitSetExample {

    private static final int MILLION = 1_000_000;
    private static final int EIGHTY_MILLION = 80* 1_000_000;

    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        System.out.println("Total memory: " + rt.totalMemory());
        System.out.println("Free memory before bit set: "+ rt.freeMemory());



        BitSet bitSet = new BitSet(EIGHTY_MILLION);

        System.out.println(bitSet);
        System.out.println("Size : " +bitSet.size());

        bitSet.set(0);
        bitSet.set(2);
        bitSet.set(80000001);
        System.out.println("Free memory after bit set: " +rt.freeMemory());
        System.out.println(bitSet);
        System.out.println("Size : " +bitSet.size());
    }
}
