package com.nagpal.bala.playgroundapp.grpc;

import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.MaxNumberRequest;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.MaxNumberResponse;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.MaxNumberServiceGrpc;
import io.grpc.stub.StreamObserver;

public class MaxNumberServiceImpl extends MaxNumberServiceGrpc.MaxNumberServiceImplBase {

    private int max = 0;

    @Override
    public StreamObserver<MaxNumberRequest> maxNumber(StreamObserver<MaxNumberResponse> responseObserver) {
          StreamObserver<MaxNumberRequest> stream = new StreamObserver<>() {
              @Override
              public void onNext(MaxNumberRequest request) {
                  int number = request.getNumber();
                  if (number > max) {
                      max = number;
                      responseObserver.onNext(MaxNumberResponse.newBuilder().setResult(number).build());
                  }
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

}
