package com.example.casearchival.controller;

import com.example.casearchival.model.CaseDetails;
import com.example.casearchival.service.CasearchivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CasearchivalController {

    @Autowired
    private CasearchivalService service;

    @GetMapping("/casedetails")
    public List<CaseDetails> getAllCase() {
        return service.getAllCase();
    }

    @GetMapping("/archivalcases")
    public List<CaseDetails> getArchivalCases() {
        return service.getArchivalCases();
    }



}
