package com.nagpal.bala.playgroundapp.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GreetingServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 5051;

            Server server = ServerBuilder.forPort(port).build();
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
