package org.example.demo_mvc.repository;


import org.example.demo_mvc.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    boolean add(Student student);
}
