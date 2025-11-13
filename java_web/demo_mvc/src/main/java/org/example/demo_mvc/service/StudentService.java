package org.example.demo_mvc.service;

import org.example.demo_mvc.entity.Student;
import org.example.demo_mvc.repository.IStudentRepository;
import org.example.demo_mvc.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService{
    private IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean add(Student student) {
        return studentRepository.add(student);
    }
}
