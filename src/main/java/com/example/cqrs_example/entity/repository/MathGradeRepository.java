package com.example.cqrs_example.entity.repository;

import com.example.cqrs_example.entity.model.grade.MathGrade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MathGradeRepository extends JpaRepository<MathGrade, Long> {
    List<MathGrade> findAllByStudentId(Long studentId);
}
