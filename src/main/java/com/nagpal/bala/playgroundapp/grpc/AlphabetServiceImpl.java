package com.nagpal.bala.playgroundapp.grpc;

import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.AlphabetRequest;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.AlphabetResponse;
import com.nagpal.bala.playgroundapp.grpc.protobuf.generated.AlphabetServiceGrpc;
import io.grpc.stub.StreamObserver;

public class AlphabetServiceImpl extends AlphabetServiceGrpc.AlphabetServiceImplBase {

    @Override
    public void alphabets(AlphabetRequest request, StreamObserver<AlphabetResponse> responseObserver) {

        int number = request.getNumber();
        if (number > 26) {
            number = 26;
        }

        AlphabetResponse.Builder response = AlphabetResponse.newBuilder();
        for (int i = 0; i < number; i++) {
            responseObserver.onNext(response.setChar(Character.toString(65+i)).build());
        }
        responseObserver.onCompleted();
    }

}
