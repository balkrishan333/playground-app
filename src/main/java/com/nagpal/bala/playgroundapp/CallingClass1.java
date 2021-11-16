package com.nagpal.bala.playgroundapp;

public class CallingClass1 {

    public void callClass1() {
        CallingClass2 class2 = new CallingClass2();
        try{
            class2.callClass2();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
