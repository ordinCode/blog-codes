package com.example.cqrs_example.service;

import com.example.cqrs_example.dto.StudentDetailResponse;
import com.example.cqrs_example.entity.model.Father;
import com.example.cqrs_example.entity.model.Mather;
import com.example.cqrs_example.entity.model.Student;
import com.example.cqrs_example.entity.model.grade.EnglishGrade;
import com.example.cqrs_example.entity.model.grade.MathGrade;
import com.example.cqrs_example.entity.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final FatherRepository fatherRepository;
    private final MatherRepository matherRepository;
    private final MathGradeRepository mathGradeRepository;
    private final EnglishGradeRepository englishGradeRepository;

    public StudentDetailResponse findStudentDetail(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow();

        Father father = fatherRepository.findByStudentId(studentId).orElseThrow();
        Mather mather = matherRepository.findByStudentId(studentId).orElseThrow();
        long familyIncome = father.getIncome() + mather.getIncome();

        double mathAverage = mathGradeRepository.findAllByStudentId(studentId).stream()
                .mapToLong(MathGrade::getScore)
                .average()
                .orElse(0);

        double englishAverage = englishGradeRepository.findAllByStudentId(studentId).stream()
                .mapToLong(EnglishGrade::getScore)
                .average()
                .orElse(0);

        return new StudentDetailResponse(
                student.getId(),
                student.getName(),
                familyIncome,
                englishAverage,
                mathAverage
        );
    }

}
