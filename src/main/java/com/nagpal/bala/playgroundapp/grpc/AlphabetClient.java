package com.nagpal.bala.playgroundapp.grpc;

import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.AlphabetRequest;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.AlphabetServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AlphabetClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 5051)
                .usePlaintext()
                .build();

        AlphabetServiceGrpc.AlphabetServiceBlockingStub stub = AlphabetServiceGrpc.newBlockingStub(channel);
        stub.alphabets(AlphabetRequest.newBuilder().setNumber(5).build()).forEachRemaining(response -> {
            System.out.println(response.getChar());
        });
    }
}
