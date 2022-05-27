package com.nagpal.bala.playgroundapp.grpc;

import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.SumNumbersRequest;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.SumNumbersResponse;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.SumNumbersServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class SumNumbersClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 5051)
                .usePlaintext()
                .build();

        int result  = doSum(channel);
        System.out.println("result = " + result);
    }

    private static int doSum(ManagedChannel channel) {
        SumNumbersServiceGrpc.SumNumbersServiceBlockingStub stub = SumNumbersServiceGrpc.newBlockingStub(channel);

        SumNumbersResponse response = stub.sumNumbers(SumNumbersRequest.newBuilder().setOne(3).setTwo(10).build());

        return response.getResult();
    }
}
