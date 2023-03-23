package com.nagpal.bala.playgroundapp.azure.servicebus;

import com.azure.core.amqp.AmqpTransportType;
import com.azure.messaging.servicebus.*;

import java.util.function.Consumer;

public class ServiceBusProcessor {

    public static final String CONNECTION_STRING = System.getenv("AZURE_SERVICEBUS_NAMESPACE_CONNECTION_STRING");
    public static final String TOPIC_NAME = "balatopic";
    public static final String SUBSCRIPTION = "app1";

    public static void main(String[] args) {
        ServiceBusProcessor obj = new ServiceBusProcessor();
        obj.process();
    }

    public void process() {

        Consumer<ServiceBusReceivedMessageContext> processMessage = context -> {
            ServiceBusReceivedMessage message = context.getMessage();
            System.out.println(message.getBody());
            context.complete();
        };

        Consumer<ServiceBusErrorContext> errorMessage = context -> {
            System.out.println(context.getException().toString());
        };


        ServiceBusProcessorClient processor = new ServiceBusClientBuilder()
                .connectionString(CONNECTION_STRING).transportType(AmqpTransportType.AMQP_WEB_SOCKETS)
                .processor().processMessage(processMessage)
                .processError(errorMessage)
                .disableAutoComplete()
                .subscriptionName(SUBSCRIPTION)
                .topicName(TOPIC_NAME).buildProcessorClient();

        processor.start();
    }
}
