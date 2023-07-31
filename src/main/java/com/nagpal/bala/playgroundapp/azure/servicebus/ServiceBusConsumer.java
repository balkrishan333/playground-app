package com.nagpal.bala.playgroundapp.azure.servicebus;

import com.azure.core.amqp.AmqpTransportType;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusReceivedMessage;
import com.azure.messaging.servicebus.ServiceBusReceiverClient;

import java.time.Duration;
import java.util.Iterator;
import java.util.stream.IntStream;

public class ServiceBusConsumer {

    public static final String CONNECTION_STRING = System.getenv("AZURE_SERVICEBUS_NAMESPACE_CONNECTION_STRING");
    public static final String TOPIC_NAME = "balatopic";
    public static final String SUBSCRIPTION = "app1";

    private final ServiceBusReceiverClient client;
    public ServiceBusConsumer() {
        client =
                new ServiceBusClientBuilder().connectionString(CONNECTION_STRING)
                        .transportType(AmqpTransportType.AMQP_WEB_SOCKETS)
                        .receiver().topicName(TOPIC_NAME)
                        .subscriptionName(SUBSCRIPTION)
                        .buildClient();
    }

    public static void main(String[] args) {
        System.out.println("Connection String: " + CONNECTION_STRING);

        ServiceBusConsumer consumer = new ServiceBusConsumer();
        IntStream.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20).forEach(i -> {
            System.out.println(consumer.receive());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        consumer.closeClient();
    }

    public String receive() {
        Iterator<ServiceBusReceivedMessage> iterator = client.receiveMessages(1).stream().iterator();
        ServiceBusReceivedMessage next = iterator.next();
        String message = next.getBody().toString();
        client.complete(next);

        return message;
//        run();
    }

    private void closeClient() {
        client.close();
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
