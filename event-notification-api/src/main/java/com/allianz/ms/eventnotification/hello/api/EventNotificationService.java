package com.allianz.ms.eventnotification.hello.api;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.broker.Topic;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.topic;

public interface EventNotificationService extends Service {

    Topic<RegistrationEvent> registrationEvents();

    String REGISTRATION_EVENTS_TOPIC = "registration-events";

    @Override
    default Descriptor descriptor() {
        return named("registration").withTopics(
                topic(REGISTRATION_EVENTS_TOPIC, this::registrationEvents)
        ).withAutoAcl(true);
    }
}