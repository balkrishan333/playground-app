package com.nagpal.bala.playgroundapp.azure.servicebus;

public class AzureServiceBusMain {

    public static void main(String[] args) throws Exception {
        AzureServiceBusMain main = new AzureServiceBusMain();
        main.send();
        Thread.sleep(10000);
        main.consume();
    }

    private void consume() {
        ServiceBusConsumer consumer = new ServiceBusConsumer();
        System.out.println(consumer.receive());
    }

    private void send() {
        ServiceBusProducer producer = new ServiceBusProducer();
        producer.send("One");
    }
}
