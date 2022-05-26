package com.nagpal.bala.playgroundapp.protobuf;

import com.nagpal.bala.playgroundapp.protobuf.generated.SimpleOuterClass;

import java.util.List;

public class SimpleMain {

    public static void main(String[] args) {
        SimpleOuterClass.Simple obj = SimpleOuterClass.Simple.newBuilder()
                .setId(1)
                .setIsSimple(true)
                .setName("Balkrishan")
                .addAllSampleList(List.of(1,2,3))
                .addSampleList(4)
                .addSampleList(5)
                .addSampleList(6)
                .build();

        System.out.println(obj);

    }
}