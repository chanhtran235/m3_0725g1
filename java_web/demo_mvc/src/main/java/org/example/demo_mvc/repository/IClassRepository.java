package org.example.demo_mvc.repository;

import org.example.demo_mvc.entity.ClassCG;

import java.util.List;

public interface IClassRepository {
    List<ClassCG> findAll();
}
