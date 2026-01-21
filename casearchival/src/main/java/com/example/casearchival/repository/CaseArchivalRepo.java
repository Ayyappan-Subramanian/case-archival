package com.example.casearchival.repository;

import com.example.casearchival.model.CaseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface CaseArchivalRepo extends JpaRepository <CaseDetails, Integer> {

    @Query("""
        SELECT c FROM CaseDetails c
        WHERE c.caseStatus = :status
        AND c.updatedDate < :cutOffDate
    """)
    public List<CaseDetails> getArchivalCases(String status, LocalDateTime cutOffDate);
}
