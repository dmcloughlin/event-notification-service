package com.allianz.ms.eventnotification.hello.impl.outputchannel;

/**
 * Created by dmcloughlin on 08/01/2018.
 */
public interface Channel<T> {

    void send(T message);
}