package com.apache.camel.Camel.Demo.controller;

import com.apache.camel.Camel.Demo.model.Student;
import com.apache.camel.Camel.Demo.service.GetStudentByNameAndEmailService;
import com.apache.camel.Camel.Demo.service.GetStudentService;
import com.apache.camel.Camel.Demo.service.SaveStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @Autowired
    private SaveStudentService saveStudentService;

    @Autowired
    private GetStudentService getStudentService;

    @Autowired
    private GetStudentByNameAndEmailService getStudentByNameAndEmailService;

    @PostMapping(value = "/save")
    ResponseEntity<Student> saveStudentssss(@RequestBody Student student) {
        Student response = saveStudentService.saveData(student);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/get/{studentId}")
    ResponseEntity<Student> saveStudentssss(@PathVariable Integer studentId) {
        Student response = getStudentService.getStudentById(studentId);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/get/{studentName}/{email}")
    ResponseEntity<Student> getByNameAndEmail(@PathVariable String studentName, @PathVariable String email) {
        Student response = getStudentByNameAndEmailService.getStudentByNameAndEmail(studentName, email);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
