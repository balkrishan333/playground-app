package com.nagpal.bala.playgroundapp.protobuf;

import com.nagpal.bala.playgroundapp.protobuf.generated.Oneofs;

public class OneOfsMain {

    public static void main(String[] args) {

        Oneofs.Result message = Oneofs.Result.newBuilder()
                .setId(1)
                .build();

        System.out.println("hasName " + message.hasName());
        System.out.println("hasId " + message.hasId());
        System.out.println(message);

        Oneofs.Result message2 = Oneofs.Result.newBuilder()
                .setName("Bala")
                .build();

        System.out.println("hasName " + message2.hasName());
        System.out.println("hasId " + message2.hasId());
        System.out.println(message2);

        //when setting both, last one will prevail
        Oneofs.Result message3 = Oneofs.Result.newBuilder()
                .setName("Bala")
                .setId(3)
                .build();

        System.out.println("hasName " + message3.hasName());
        System.out.println("hasId " + message3.hasId());
        System.out.println(message3);

    }
}
