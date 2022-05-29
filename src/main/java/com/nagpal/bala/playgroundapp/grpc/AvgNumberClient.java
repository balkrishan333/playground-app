package com.nagpal.bala.playgroundapp.grpc;

import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.AvgNumbersGrpc;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.AvgNumbersRequest;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.AvgNumbersResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AvgNumberClient {

    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 5051)
                .usePlaintext()
                .build();

        AvgNumbersGrpc.AvgNumbersStub stub = AvgNumbersGrpc.newStub(channel);
        List<Integer> numbers = List.of(1,2,3,4,5);
        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<AvgNumbersRequest> stream = stub.avg(new StreamObserver<>() {
            @Override
            public void onNext(AvgNumbersResponse response) {
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

        for (Integer val : numbers) {
            stream.onNext(AvgNumbersRequest.newBuilder().setNumber(val).build());
        }

        stream.onCompleted();
        latch.await(3, TimeUnit.SECONDS);
    }
}
