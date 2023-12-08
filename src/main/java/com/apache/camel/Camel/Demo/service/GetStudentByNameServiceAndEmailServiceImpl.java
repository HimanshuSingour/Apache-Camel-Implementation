package com.apache.camel.Camel.Demo.service;

import com.apache.camel.Camel.Demo.model.Student;
import com.apache.camel.Camel.Demo.service.GetStudentByNameAndEmailService;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GetStudentByNameServiceAndEmailServiceImpl implements GetStudentByNameAndEmailService {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Override
    public Student getStudentByNameAndEmail(String studentName, String email) {

        producerTemplate.start();
        Exchange result = producerTemplate.send("direct:saveEmailName", exchange -> {
            exchange.getIn().setHeader("studentName", studentName);
            exchange.getIn().setHeader("email", email);
        });
        producerTemplate.stop();
        return result.getIn().getBody(Student.class);

    }
}
