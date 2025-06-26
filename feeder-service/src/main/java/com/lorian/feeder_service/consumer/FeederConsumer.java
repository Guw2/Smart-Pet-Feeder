package com.lorian.feeder_service.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class FeederConsumer {

	@RabbitListener(queues = "pet-feeder-queue") // Listens to a specific queue
	public void sensorActivated(@Payload Message<?> msg) {
		// Prints the payload to the console
		System.out.println(msg.getPayload());
	}
	
}
