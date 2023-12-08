package com.apache.camel.Camel.Demo.service;

import com.apache.camel.Camel.Demo.model.Student;
import com.apache.camel.Camel.Demo.service.SaveStudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class SaveStudentServiceImpl implements SaveStudentService {

    @Autowired
    private final ProducerTemplate producerTemplate;

    @Override
    public Student saveData(Student student) {

        producerTemplate.start();
        Student response = producerTemplate
                .requestBody("direct:saveStudent", student, Student.class);
        producerTemplate.stop();
        return response;
    }


}


