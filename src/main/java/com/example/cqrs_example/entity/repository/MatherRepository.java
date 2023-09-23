package com.example.cqrs_example.entity.repository;

import com.example.cqrs_example.entity.model.Mather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatherRepository extends JpaRepository<Mather, Long> {
    Optional<Mather> findByStudentId(Long studentId);
}
