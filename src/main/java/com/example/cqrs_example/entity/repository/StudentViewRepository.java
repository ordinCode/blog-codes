package com.example.cqrs_example.entity.repository;

import com.example.cqrs_example.entity.model.StudentView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentViewRepository extends JpaRepository<StudentView, Long> {
}
