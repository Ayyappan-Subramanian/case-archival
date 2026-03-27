package com.example.casearchival.repoArchival;

import com.example.casearchival.model.CaseDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArchivalCasesRepo extends JpaRepository<CaseDetails, Integer> {
}
