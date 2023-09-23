package com.example.cqrs_example.entity.repository;

import com.example.cqrs_example.entity.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
