package com.nagpal.bala.playgroundapp;

import com.nagpal.bala.playgroundapp.pulsar.PulsarConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlaygroundAppApplication {

	@Autowired
	private PulsarConsumer pulsarConsumer;

	public static void main(String[] args) {
		SpringApplication.run(PlaygroundAppApplication.class, args);
	}
}
