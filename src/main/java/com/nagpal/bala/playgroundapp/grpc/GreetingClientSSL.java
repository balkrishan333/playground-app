package com.nagpal.bala.playgroundapp.grpc;

import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.GreetingRequest;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.GreetingResponse;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.GreetingServiceGrpc;
import io.grpc.*;
import io.grpc.stub.StreamObserver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class GreetingClientSSL {

    public static void main(String[] args) throws InterruptedException, IOException {

        ChannelCredentials channelCredentials = TlsChannelCredentials.newBuilder()
                                                    .trustManager(new File("ssl/ca.crt")).build();

        ManagedChannel channel = Grpc.newChannelBuilderForAddress("localhost", 5052, channelCredentials).build();

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
