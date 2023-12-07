package com.apache.camel.Camel.Demo.process;

public interface MessageProcessor<T> {

    void process(T exchange);
}
