package org.example.demo_mvc.service;

import org.example.demo_mvc.entity.ClassCG;
import org.example.demo_mvc.repository.ClassRepository;
import org.example.demo_mvc.repository.IClassRepository;

import java.util.List;

public class ClassService implements IClassService {
    private IClassRepository classRepository = new ClassRepository();
    @Override
    public List<ClassCG> findAll() {
        return classRepository.findAll();
    }
}
