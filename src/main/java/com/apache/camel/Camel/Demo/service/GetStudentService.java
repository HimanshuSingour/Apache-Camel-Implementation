package com.apache.camel.Camel.Demo.service;

import com.apache.camel.Camel.Demo.model.Student;

public interface GetStudentService {

    Student getStudentById(Integer studentId);
}
