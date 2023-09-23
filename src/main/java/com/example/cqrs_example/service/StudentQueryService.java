package com.example.cqrs_example.service;

import com.example.cqrs_example.dto.StudentDetailResponse;
import com.example.cqrs_example.entity.repository.StudentViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentQueryService {
    private final StudentViewRepository studentViewRepository;

    public List<StudentDetailResponse> findAllStudentDetail() {
        return studentViewRepository.findAll().stream()
                .map(studentView -> new StudentDetailResponse(
                        studentView.getStudentId(),
                        studentView.getStudentName(),
                        studentView.getFamilyIncome(),
                        studentView.getAverageEnglishScore(),
                        studentView.getAverageMathScore()
                ))
                .collect(Collectors.toList());
    }
}
