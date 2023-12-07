package com.apache.camel.Camel.Demo.process.impl;

import com.apache.camel.Camel.Demo.model.Student;
import com.apache.camel.Camel.Demo.process.MessageProcessor;
import com.apache.camel.Camel.Demo.repository.StudentRepository;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetStudentByNameAndEmailProcess implements MessageProcessor<Exchange> {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void process(Exchange exchange) {

        String studentName = exchange.getIn().getHeader("studentName", String.class);
        String email = exchange.getIn().getHeader("email", String.class);

        if (studentName != null && email != null) {
            Student student = studentRepository.getByNameAndEmail(studentName, email);
            exchange.getIn().setBody(student);
        } else {
            exchange.getIn().setBody("No student found with the given name and email");
        }

    }
}
