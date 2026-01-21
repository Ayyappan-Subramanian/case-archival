package com.example.casearchival.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Scope("prototype")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CaseDetails {
@Id
    private int caseId;
    private String caseType;
    private String caseStatus;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

}
