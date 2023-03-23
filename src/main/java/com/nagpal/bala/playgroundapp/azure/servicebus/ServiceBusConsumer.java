package com.nagpal.bala.playgroundapp.azure.servicebus;

import com.azure.core.amqp.AmqpTransportType;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusReceivedMessage;
import com.azure.messaging.servicebus.ServiceBusReceiverClient;

import java.time.Duration;
import java.util.Iterator;

public class ServiceBusConsumer {

    public static final String CONNECTION_STRING = System.getenv("AZURE_SERVICEBUS_NAMESPACE_CONNECTION_STRING");
    public static final String TOPIC_NAME = "balatopic";
    public static final String SUBSCRIPTION = "app1";

    public static void main(String[] args) {
        ServiceBusConsumer consumer = new ServiceBusConsumer();
        System.out.println(consumer.receive());
    }

    public String receive() {

        System.out.println("Connection String: " + CONNECTION_STRING);
        ServiceBusReceiverClient client =
                new ServiceBusClientBuilder().connectionString(CONNECTION_STRING)
                        .transportType(AmqpTransportType.AMQP_WEB_SOCKETS)
                        .receiver().topicName(TOPIC_NAME)
                        .subscriptionName(SUBSCRIPTION)
                        .buildClient();

        Iterator<ServiceBusReceivedMessage> iterator = client.receiveMessages(1).stream().iterator();

        String message = iterator.next().getBody().toString();
        client.close();

        return message;
//        run();
//        return "OK";
    }

    public void run() {

        // Create a receiver.
        // "<<fully-qualified-namespace>>" will look similar to "{your-namespace}.servicebus.windows.net"
        // "<<queue-name>>" will be the name of the Service Bus queue instance you created
        // inside the Service Bus namespace.
        // Each message's lock is renewed up to 1 minute.
        ServiceBusReceiverClient receiver = new ServiceBusClientBuilder()
                .connectionString(CONNECTION_STRING)
                .receiver()
                .maxAutoLockRenewDuration(Duration.ofMinutes(1))
                .topicName(TOPIC_NAME)
                .subscriptionName(SUBSCRIPTION)
                .buildClient();

        // Try to receive a set of messages from Service Bus 10 times. A batch of messages are returned when 5 messages
        // are received, or the operation timeout has elapsed, whichever occurs first.
        for (int i = 0; i < 10; i++) {

            receiver.receiveMessages(5).stream().forEach(message -> {
                // Process message. The message lock is renewed for up to 1 minute.
                System.out.printf("Sequence #: %s. Contents: %s%n", message.getSequenceNumber(), message.getBody());

                // Messages from the sync receiver MUST be settled explicitly.
                receiver.complete(message);
            });
        }

        // Close the receiver.
        receiver.close();
    }
}
