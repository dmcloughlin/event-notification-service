package com.allianz.ms.eventnotification.hello.impl;

import akka.Done;
import akka.NotUsed;
import akka.japi.Pair;
import com.allianz.ms.eventnotification.hello.api.RegistrationEvent;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.broker.Topic;
import com.lightbend.lagom.javadsl.broker.TopicProducer;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRef;
import com.lightbend.lagom.javadsl.persistence.PersistentEntityRegistry;

import javax.inject.Inject;

import com.allianz.ms.eventnotification.hello.api.EventNotificationService;
import com.allianz.ms.eventnotification.hello.impl.HelloCommand.*;

/**
 * Implementation of the EventNotificationService.
 */
public class EventNotificationServiceImpl implements EventNotificationService {

  @Override
  public Topic<RegistrationEvent> registrationEvents() {
    return null;
  }
}