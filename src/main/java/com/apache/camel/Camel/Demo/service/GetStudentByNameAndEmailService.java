package com.apache.camel.Camel.Demo.service;

import com.apache.camel.Camel.Demo.model.Student;

public interface GetStudentByNameAndEmailService {

    Student getStudentByNameAndEmail(String name , String email);
}
