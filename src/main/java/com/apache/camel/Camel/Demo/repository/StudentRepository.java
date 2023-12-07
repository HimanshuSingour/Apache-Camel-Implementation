package com.apache.camel.Camel.Demo.repository;


import com.apache.camel.Camel.Demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.studentName = :studentName AND s.email = :email")
    Student getByNameAndEmail(String studentName, String email);
}
