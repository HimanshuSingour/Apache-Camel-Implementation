package com.apache.camel.Camel.Demo.process.impl;

import com.apache.camel.Camel.Demo.model.Student;
import com.apache.camel.Camel.Demo.process.MessageProcessor;
import com.apache.camel.Camel.Demo.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SaveStudentProcess implements MessageProcessor<Exchange> {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void process(Exchange exchange) {

        Student student = exchange.getIn().getBody(Student.class);
        studentRepository.save(student);
        exchange.getIn().setBody(student);

    }

}


