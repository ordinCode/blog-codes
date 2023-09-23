package com.example.cqrs_example.entity.repository;

import com.example.cqrs_example.entity.model.Father;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FatherRepository extends JpaRepository<Father, Long> {
    Optional<Father> findByStudentId(Long studentId);
}
