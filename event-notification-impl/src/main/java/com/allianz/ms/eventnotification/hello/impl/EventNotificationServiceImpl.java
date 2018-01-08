package com.allianz.ms.eventnotification.hello.impl;

import akka.Done;
import akka.stream.javadsl.Flow;
import com.allianz.ms.eventnotification.hello.api.EventNotificationService;
import com.allianz.ms.eventnotification.hello.impl.outputchannel.EmailChannel;
import com.allianz.ms.user.api.RegistrationEvent;
import com.allianz.ms.user.api.RegistrationService;
import com.lightbend.lagom.javadsl.api.broker.Subscriber;
import com.lightbend.lagom.javadsl.api.broker.Topic;

import javax.annotation.processing.Completion;
import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Implementation of the EventNotificationService.
 */
public class EventNotificationServiceImpl implements EventNotificationService {

    @Inject
    public EventNotificationServiceImpl(RegistrationService registrationService) {


        registrationService
                .registrationTopic()
                .subscribe()
                .atLeastOnce(Flow.fromFunction(e -> handleEventNotification(e)));
    }

    private Done handleEventNotification(RegistrationEvent e) {

        System.out.println("Registration Event received - Sending Notification" + e.toString());

        if (e instanceof RegistrationEvent.PolicyAndEmailCombinationVerified) {

            System.out.println("Sending email...");
            new EmailChannel().send(e);
        }

        return Done.getInstance();
    }
}