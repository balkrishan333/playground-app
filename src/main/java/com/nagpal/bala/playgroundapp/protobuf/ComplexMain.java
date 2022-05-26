package com.nagpal.bala.playgroundapp.protobuf;

import com.nagpal.bala.playgroundapp.protobuf.generated.ComplexOuterClass;

import java.util.Arrays;

public class ComplexMain {

    private static ComplexOuterClass.Dummy newDummy(int id, String name) {
        ComplexOuterClass.Dummy dummy = ComplexOuterClass.Dummy.newBuilder()
                .setId(id)
                .setName(name)
                .build();

        return dummy;
    }

    public static void main(String[] args) {
        ComplexOuterClass.Complex complex = ComplexOuterClass.Complex.newBuilder()
                .setOneDummy(newDummy(1, "one"))
                .addAllDummies(
                        Arrays.asList(
                                newDummy(2, "two"),
                                newDummy(3, "three"),
                                newDummy(4, "four")
                        )
                )
                .build();

        System.out.println(complex);
    }
}
