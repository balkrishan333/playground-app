package com.nagpal.bala.playgroundapp.grpc;

import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.MaxNumberRequest;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.MaxNumberResponse;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.MaxNumberServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class MaxNumberClient {

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 5051)
                .usePlaintext()
                .build();

        MaxNumberServiceGrpc.MaxNumberServiceStub stub = MaxNumberServiceGrpc.newStub(channel);
        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<MaxNumberRequest> stream = stub.maxNumber(new StreamObserver<>() {
            @Override
            public void onNext(MaxNumberResponse response) {
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

        Stream.of(1,5,3,6,2,20).forEach(number -> {
            stream.onNext(MaxNumberRequest.newBuilder().setNumber(number).build());
        });

        latch.await(3, TimeUnit.SECONDS);
    }
}
