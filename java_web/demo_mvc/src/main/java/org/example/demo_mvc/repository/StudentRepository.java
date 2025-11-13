package org.example.demo_mvc.repository;


import org.example.demo_mvc.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
     private static List<Student> studentList = new ArrayList<>();
     static {
         studentList.add(new Student(1,"chánh",true,7.0f));
         studentList.add(new Student(2,"Sự",false,1.0f));
         studentList.add(new Student(3,"hải",true,9.0f));
         studentList.add(new Student(4,"trung",true,5.0f));
     }
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public boolean add(Student student) {
        return studentList.add(student);
    }
}
