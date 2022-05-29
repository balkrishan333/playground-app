package com.nagpal.bala.playgroundapp.grpc;

import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.AvgNumbersGrpc;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.AvgNumbersRequest;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.AvgNumbersResponse;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.List;

public class AvgNumbersServiceImpl extends AvgNumbersGrpc.AvgNumbersImplBase {

    public StreamObserver<AvgNumbersRequest> avg(StreamObserver<AvgNumbersResponse> responseObserver) {

        List<Integer> numbers = new ArrayList<>();

        StreamObserver<AvgNumbersRequest> stream = new StreamObserver<>() {
            @Override
            public void onNext(AvgNumbersRequest request) {
                numbers.add(request.getNumber());
            }

            @Override
            public void onError(Throwable t) {
                responseObserver.onError(t);
            }

            @Override
            public void onCompleted() {
                double result = numbers.stream().mapToInt(Integer::intValue).sum() / numbers.stream().count();
                responseObserver.onNext(AvgNumbersResponse.newBuilder().setResult(result).build());
                responseObserver.onCompleted();
            }
        };

        return stream;
    }
}
