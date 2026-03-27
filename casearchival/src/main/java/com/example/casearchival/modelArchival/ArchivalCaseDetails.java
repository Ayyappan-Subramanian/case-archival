package com.example.casearchival.modelArchival;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Scope("prototype")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ArchivalCaseDetails {

    @Id
    private int caseId;
    private String caseType;
    private String caseStatus;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
