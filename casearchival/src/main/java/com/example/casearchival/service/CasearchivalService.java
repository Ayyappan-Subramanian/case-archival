package com.example.casearchival.service;

import com.example.casearchival.enums.Status;
import com.example.casearchival.model.CaseDetails;
import com.example.casearchival.repoArchival.ArchivalCasesRepo;
import com.example.casearchival.repoPrimary.PrimaryCasesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CasearchivalService {

    @Autowired
    public PrimaryCasesRepo repo;

    @Autowired
    public ArchivalCasesRepo archrepo;

    public List<CaseDetails> getAllCase() throws InterruptedException{

        return repo.findAll();
    }

    public List<CaseDetails> getArchivalCases() {
        LocalDateTime cutOffDate = LocalDateTime.now().minusDays(5);
        String status = "Resolved";
        return (repo.findByCaseStatusAndUpdatedDateBefore(status, cutOffDate));
    }

    public CaseDetails addPrimaryCases(CaseDetails casedetails) {
        return repo.save(casedetails);
    }

    public CaseDetails addArchivalCases(CaseDetails casedetails) {
        return archrepo.save(casedetails);
    }

    public void deletePrimaryCases(int id) {
        repo.deleteById(id);
    }

    public String runarchival(){
        List<CaseDetails> l = getArchivalCases();
        int count = 0;

        for(CaseDetails c : l) {
            int updated = repo.markAsArchive(c.getCaseId());
            if(updated == 0) {
                if(c.getStatus() != Status.PICKED_FOR_ARCHIVAL) {
                    continue;
                }
                LocalDateTime threshold = LocalDateTime.now().minusMinutes(5);
                if(c.getUpdatedDate().isAfter(threshold))
                {
                    continue;
                }
            }
            addArchivalCases(c);
            deletePrimaryCases(c.getCaseId());
        }
        return "Success";
    }
}
