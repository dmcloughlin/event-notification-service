package com.allianz.ms.eventnotification.hello.impl;

import com.allianz.ms.eventnotification.hello.api.EventNotificationService;
import com.allianz.ms.user.api.RegistrationService;
import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

/**
 * The module that binds the EventNotificationService so that it can be served.
 */
public class HelloModule extends AbstractModule implements ServiceGuiceSupport {
    @Override
    protected void configure() {

        bindService(EventNotificationService.class, EventNotificationServiceImpl.class);
        bindClient(RegistrationService.class);
        //bind(KafkaConsumer.class).asEagerSingleton();
    }
}
