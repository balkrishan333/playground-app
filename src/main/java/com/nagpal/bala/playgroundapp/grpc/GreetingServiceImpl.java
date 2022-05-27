package com.nagpal.bala.playgroundapp.grpc;

import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.GreetingRequest;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.GreetingResponse;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greet(GreetingRequest greetingRequest, StreamObserver<GreetingResponse> responseObserver) {
        responseObserver.onNext(GreetingResponse.newBuilder().setResult("Hello " + greetingRequest.getFirstName()).build());
        responseObserver.onCompleted();
    }
}
