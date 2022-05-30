package com.nagpal.bala.playgroundapp.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GRPCServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 5051;

            Server server = ServerBuilder
                    .forPort(port)
                    .addService(new GreetingServiceImpl())
                    .addService(new SumNumbersServiceImpl())
                    .addService(new AlphabetServiceImpl())
                    .addService(new AvgNumbersServiceImpl())
                    .addService(new MaxNumberServiceImpl())
                    .build();
            server.start();

        System.out.println("Server started on port : " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Running shutdown hook");
            server.shutdown();
            System.out.println("Server stopped.");
        }));

        server.awaitTermination();

    }
}
