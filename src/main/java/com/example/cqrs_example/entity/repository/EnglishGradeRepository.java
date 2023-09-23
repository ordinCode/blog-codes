package com.example.cqrs_example.entity.repository;

import com.example.cqrs_example.entity.model.grade.EnglishGrade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnglishGradeRepository extends JpaRepository<EnglishGrade, Long> {
    List<EnglishGrade> findAllByStudentId(Long studentId);

}
