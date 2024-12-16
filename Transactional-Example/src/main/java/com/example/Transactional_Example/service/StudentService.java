package com.example.Transactional_Example.service;

import com.example.Transactional_Example.model.Student;
import com.example.Transactional_Example.model.Subject;
import com.example.Transactional_Example.repo.StudentRepository;
import com.example.Transactional_Example.repo.SubjectRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Transactional
    public void saveStudentAndSubjects(Student student, List<Subject> subjects) {
        Student savedStudent = studentRepository.save(student);

        for (Subject subject : subjects) {
            subject.setStudent(savedStudent);  // Assign the saved student to the subject
            subjectRepository.save(subject);
        }
    }
}
