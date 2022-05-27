package com.nagpal.bala.playgroundapp.grpc;

import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.GreetingRequest;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.GreetingResponse;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.GreetingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder
                                    .forAddress("localhost", 5051)
                                    .usePlaintext()
                                    .build();

        //do something over the channel
        doGreet(channel);

        System.out.println("Closing channel..");
        channel.shutdown();
    }

    public static void doGreet(ManagedChannel channel) {
        System.out.println("Inside doGreet");
        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);
        GreetingResponse response = stub.greet(GreetingRequest.newBuilder().setFirstName("Balkrishan").build());

        System.out.println(response.getResult());
    }
}
