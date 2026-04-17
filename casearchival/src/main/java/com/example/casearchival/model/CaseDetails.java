package com.example.casearchival.model;

import com.example.casearchival.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class CaseDetails {
@Id
    private int caseId;
    private String caseType;
    private String caseStatus;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    @Enumerated(EnumType.STRING)
    private Status status;

}
