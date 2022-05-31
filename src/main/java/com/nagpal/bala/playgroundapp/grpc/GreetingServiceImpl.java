package com.nagpal.bala.playgroundapp.grpc;

import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.GreetingRequest;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.GreetingResponse;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.GreetingServiceGrpc;
import io.grpc.Context;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greet(GreetingRequest greetingRequest, StreamObserver<GreetingResponse> responseObserver) {
        responseObserver.onNext(GreetingResponse.newBuilder().setResult("Hello " + greetingRequest.getFirstName()).build());
        responseObserver.onCompleted();
    }

    @Override
    public void greetManyTimes(GreetingRequest greetingRequest, StreamObserver<GreetingResponse> responseObserver) {
        GreetingResponse response = GreetingResponse.newBuilder().setResult("Hello " + greetingRequest.getFirstName()).build();

        for (int i = 0; i < 10; i++) {
            responseObserver.onNext(response);
        }
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<GreetingRequest> longGreet(StreamObserver<GreetingResponse> responseObserver) {

        StringBuilder sb = new StringBuilder();
        StreamObserver<GreetingRequest> stream = new StreamObserver<>() {
            @Override
            public void onNext(GreetingRequest request) {
                sb.append("Hello ")
                        .append(request.getFirstName())
                        .append(" !\n");
            }

            @Override
            public void onError(Throwable t) {
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(GreetingResponse.newBuilder().setResult(sb.toString()).build());
                responseObserver.onCompleted();
            }
        };
        return stream;
    }

    @Override
    public StreamObserver<GreetingRequest> greetEveryOne(StreamObserver<GreetingResponse> responseObserver) {
        StreamObserver<GreetingRequest> stream = new StreamObserver<>() {
            @Override
            public void onNext(GreetingRequest request) {
                responseObserver.onNext(GreetingResponse.newBuilder().setResult("Hello " + request.getFirstName()).build());
            }

            @Override
            public void onError(Throwable t) {
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
        return stream;
    }

    @Override
    public void hanldeError(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        String name = request.getFirstName();

        if (name.equalsIgnoreCase("bad")) {
            responseObserver.onError(Status.INVALID_ARGUMENT
                            .withDescription("Bad guy to greet")
                            .augmentDescription("Argument " + name)
                    .asRuntimeException());

            return;
        }
        responseObserver.onNext(GreetingResponse.newBuilder().setResult("Hello " + name).build());
        responseObserver.onCompleted();
    }

    @Override
    public void greetWithDeadline(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        Context ctx = Context.current();

        for (int i = 0; i < 15; i++) {
            if (ctx.isCancelled()) {
                return;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                responseObserver.onError(e);
            }
        }

        responseObserver.onNext(GreetingResponse.newBuilder().setResult("Deadlined Grretings " + request.getFirstName()).build());
        responseObserver.onCompleted();
    }
}
