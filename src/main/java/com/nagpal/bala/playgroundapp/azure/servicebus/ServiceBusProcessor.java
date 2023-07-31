package com.nagpal.bala.playgroundapp.azure.servicebus;

import com.azure.core.amqp.AmqpTransportType;
import com.azure.messaging.servicebus.*;

import java.util.function.Consumer;

public class ServiceBusProcessor {

    public static final String CONNECTION_STRING = System.getenv("AZURE_SERVICEBUS_NAMESPACE_CONNECTION_STRING");
    public static final String TOPIC_NAME = "balatopic";
    public static final String SUBSCRIPTION = "app1";

    private final ServiceBusProcessorClient processor;

    private final Consumer<String> processMessageInner = str -> {
        System.out.println("From inner consumer..." + str);
    };
    private final Consumer<ServiceBusReceivedMessageContext> processMessage = context -> {
        ServiceBusReceivedMessage message = context.getMessage();
        System.out.println(message.getBody());
        processMessageInner.accept(message.getBody().toString());
        context.complete();
    };

    private final Consumer<ServiceBusErrorContext> errorMessage = context -> {
        System.out.println(context.getException().toString());
    };

    public ServiceBusProcessor() {
        processor = new ServiceBusClientBuilder()
                .connectionString(CONNECTION_STRING).transportType(AmqpTransportType.AMQP_WEB_SOCKETS)
                .processor()
                .processMessage(processMessage)
                .processError(errorMessage)
                .disableAutoComplete()
                .subscriptionName(SUBSCRIPTION)
                .disableAutoComplete()
                .topicName(TOPIC_NAME).buildProcessorClient();
    }

    public static void main(String[] args) {
        ServiceBusProcessor obj = new ServiceBusProcessor();
        obj.process();
    }

    public void process() {
        processor.start();
        System.out.println("Processor started...");
    }
}
