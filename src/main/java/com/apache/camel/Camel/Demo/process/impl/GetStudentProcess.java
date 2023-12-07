package com.apache.camel.Camel.Demo.process.impl;

import com.apache.camel.Camel.Demo.model.Student;
import com.apache.camel.Camel.Demo.process.MessageProcessor;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class GetStudentProcess implements MessageProcessor<Exchange> {
    @Override
    public void process(Exchange exchange) {

        Student student = exchange.getIn().getBody(Student.class);
        if (student != null) {
            exchange.getIn().setBody(student);
        }

    }
}
