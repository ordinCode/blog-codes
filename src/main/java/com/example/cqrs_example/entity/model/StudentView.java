package com.example.cqrs_example.entity.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class StudentView {
    @Id
    private Long studentId;
    private String studentName;
    private Long fatherId;
    private Long fatherIncome;
    private Long matherId;
    private Long matherIncome;
    private Long familyIncome;
    private Double averageEnglishScore;
    private Double averageMathScore;
}
