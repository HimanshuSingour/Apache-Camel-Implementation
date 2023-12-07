package com.apache.camel.Camel.Demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "STUDENT_TABLE")
public class Student {

    @Id
    private int studentId;
    private String studentName;
    private String email;
}
