/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Transactional_Example.controller;

import com.example.Transactional_Example.dto.StudentDto;
import com.example.Transactional_Example.model.Student;
import com.example.Transactional_Example.model.Subject;
import com.example.Transactional_Example.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<String> saveStudent(@RequestBody StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());

        // Convert subjects from DTO to entity
        List<Subject> subjects = new ArrayList<>();
        for (String subjectName : studentDto.getSubjects()) {
            Subject subject = new Subject();
            subject.setSubjectName(subjectName);
            subjects.add(subject);
        }

        try {
            studentService.saveStudentAndSubjects(student, subjects);
            return ResponseEntity.ok("Student and subjects saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save student and subjects.");
        }
    }
}
