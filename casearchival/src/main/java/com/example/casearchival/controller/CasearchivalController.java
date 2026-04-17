package com.example.casearchival.controller;

import com.example.casearchival.model.CaseDetails;
import com.example.casearchival.service.CasearchivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CasearchivalController {

    @Autowired
    private CasearchivalService service;

    @GetMapping("/casedetails")
    public List<CaseDetails> getAllCase() {
        return service.getAllCase();
    }

    @GetMapping("/getarchivalcases")
    public List<CaseDetails> getArchivalCases() {
        return service.getArchivalCases();
    }

    @PostMapping("/addprimarycases")
    public CaseDetails addPrimaryCases(@RequestBody CaseDetails casedetails) {
        return service.addPrimaryCases(casedetails);
    }
    @PostMapping("/addarchivalcases")
    public CaseDetails addArchivalCases(@RequestBody CaseDetails casedetails) {
        return service.addArchivalCases(casedetails);
    }

    @GetMapping("/runarchivalprocess")
    public String runarchival(){
        return service.runarchival();
    }

    @DeleteMapping("/deleteprimarycase/{id}")
    public ResponseEntity<Void> deletePrimaryCases(@PathVariable int id){
        service.deletePrimaryCases(id);
        return ResponseEntity.noContent().build();
    }

}
