package com.allianz.ms.eventnotification.hello.impl;

import akka.Done;
import akka.stream.javadsl.Flow;
import com.allianz.ms.eventnotification.hello.api.EventNotificationService;
import com.allianz.ms.eventnotification.hello.api.RegistrationEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by dmcloughlin on 05/01/2018.
 */

@Singleton
public class KafkaConsumer {

    private final EventNotificationService eventNotificationService;
    private ObjectMapper jsonMapper = new ObjectMapper();

    @Inject
    public KafkaConsumer(EventNotificationService notificationService) {
        this.eventNotificationService = notificationService;
        this.eventNotificationService.registrationEvents().subscribe()
                .atLeastOnce(Flow.fromFunction(this::handleEventNotification));
    }

    private Done handleEventNotification(RegistrationEvent message) {
        System.out.println("Message :::::::::::  " + message);
//
//        try {
//            GreetingMessage greetingMessage = jsonMapper.readValue(message, GreetingMessage.class);
//            if (StringUtils.isNotEmpty(greetingMessage.message)) {
//                System.out.println("Action performed :::::::::::  " + message);
//
//                // Do your action here
//            }
//        } catch (Exception ex) {
//            System.out.println("Error in consuming kafka message");
//        }
        return Done.getInstance();
    }
}
