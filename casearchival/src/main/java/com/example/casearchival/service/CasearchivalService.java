package com.example.casearchival.service;

import com.example.casearchival.model.CaseDetails;
import com.example.casearchival.repository.CaseArchivalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CasearchivalService {

    @Autowired
    public CaseArchivalRepo repo;

    public List<CaseDetails> getAllCase() {
        return repo.findAll();
    }

    public List<CaseDetails> getArchivalCases() {
        LocalDateTime cutOffDate = LocalDateTime.now().minusDays(1);
        String status = "Resolved";
        return (repo.getArchivalCases(status, cutOffDate));
    }
}
