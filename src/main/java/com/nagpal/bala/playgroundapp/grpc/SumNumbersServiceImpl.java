package com.nagpal.bala.playgroundapp.grpc;

import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.SumNumbersRequest;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.SumNumbersResponse;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.SumNumbersServiceGrpc;
import io.grpc.stub.StreamObserver;

public class SumNumbersServiceImpl extends SumNumbersServiceGrpc.SumNumbersServiceImplBase {

    @Override
    public void sumNumbers(SumNumbersRequest request, StreamObserver<SumNumbersResponse> responseObserver) {

        System.out.println("Calculating sum...");
        int result = request.getOne() + request.getTwo();
        responseObserver.onNext(SumNumbersResponse.newBuilder().setResult(result).build());
        responseObserver.onCompleted();

    }
}
