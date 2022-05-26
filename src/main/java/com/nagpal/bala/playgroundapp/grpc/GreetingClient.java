package com.nagpal.bala.playgroundapp.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5051)
                .usePlaintext()
                .build();

        //do something over the channel

        System.out.println("Closing channel..");
        channel.shutdown();
    }
}
