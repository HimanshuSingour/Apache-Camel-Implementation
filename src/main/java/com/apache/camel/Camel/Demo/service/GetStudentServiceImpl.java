package com.apache.camel.Camel.Demo.service;

import com.apache.camel.Camel.Demo.model.Student;
import com.apache.camel.Camel.Demo.service.GetStudentService;
import lombok.RequiredArgsConstructor;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetStudentServiceImpl implements GetStudentService {

    @Autowired
    private final ProducerTemplate producerTemplate;

    @Override
    public Student getStudentById(Integer studentId) {

        producerTemplate.start();
        Student response = producerTemplate
                .requestBody("direct:getStudent", studentId, Student.class);
        producerTemplate.stop();
        return response;

    }
}
