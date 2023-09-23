package com.example.cqrs_example.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class StudentDetailResponse {
    private Long studentId;
    private String studentName;
    private Long familyIncome;
    private Double averageEnglishScore;
    private Double averageMathScore;
}
