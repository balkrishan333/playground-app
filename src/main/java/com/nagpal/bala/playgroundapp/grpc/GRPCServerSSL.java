package com.nagpal.bala.playgroundapp.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.File;
import java.io.IOException;

public class GRPCServerSSL {

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 5052;

            Server server = ServerBuilder
                    .forPort(port)
                    .useTransportSecurity(new File("ssl/server.crt"), new File("ssl/server.pem"))
                    .addService(new GreetingServiceImpl())
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
