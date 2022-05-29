package com.nagpal.bala.playgroundapp.grpc;

import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.GreetingRequest;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.GreetingResponse;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.GreetingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GreetingClient {

    public static void main(String[] args) throws InterruptedException {

        ManagedChannel channel = ManagedChannelBuilder
                                    .forAddress("localhost", 5051)
                                    .usePlaintext()
                                    .build();

        //do something over the channel
//        doGreet(channel);
//        doGreetManyTimes(channel);
        longGreet(channel);

        System.out.println("Closing channel..");
        channel.shutdown();
    }

    public static void doGreet(ManagedChannel channel) {
        System.out.println("Inside doGreet");
        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);
        GreetingResponse response = stub.greet(GreetingRequest.newBuilder().setFirstName("Balkrishan").build());

        System.out.println(response.getResult());
    }

    private static void doGreetManyTimes(ManagedChannel channel) {
        System.out.println("Inside Greet many times");
        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);

        stub.greetManyTimes(GreetingRequest.newBuilder().setFirstName("Bala").build()).forEachRemaining(response -> {
            System.out.println(response.getResult());
        });
    }

    private static void longGreet(ManagedChannel channel) throws InterruptedException {
        System.out.println("Inside LongGreet..");
        GreetingServiceGrpc.GreetingServiceStub stub = GreetingServiceGrpc.newStub(channel);

        CountDownLatch latch = new CountDownLatch(1);
        List<String> names = List.of("Balkrishan", "Shikha", "Khwaish", "Etasha");
        StreamObserver<GreetingRequest> stream = stub.longGreet(new StreamObserver<>() {
            @Override
            public void onNext(GreetingResponse response) {
                System.out.println(response.getResult());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
              latch.countDown();
            }
        });

        for(String name : names) {
            stream.onNext(GreetingRequest.newBuilder().setFirstName(name).build());
        }

        stream.onCompleted();
        latch.await(3, TimeUnit.SECONDS);
    }
}
