package com.allianz.ms.eventnotification.hello.api;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;

import static com.lightbend.lagom.javadsl.api.Service.named;

public interface EventNotificationService extends Service {

    @Override
    default Descriptor descriptor() {

        return named("event-notification");
    }
}