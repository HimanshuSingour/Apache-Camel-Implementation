package com.apache.camel.Camel.Demo.process.impl;

import com.apache.camel.Camel.Demo.process.MessageProcessor;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class MessageOccureProcess implements MessageProcessor<Exchange> {
    @Override
    public void process(Exchange exchange) {

        System.out.println("Message PRocess");

    }
}
