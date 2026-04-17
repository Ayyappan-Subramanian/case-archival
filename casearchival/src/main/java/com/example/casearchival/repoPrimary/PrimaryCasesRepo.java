package com.example.casearchival.repoPrimary;

import com.example.casearchival.enums.Status;
import com.example.casearchival.model.CaseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface PrimaryCasesRepo extends JpaRepository <CaseDetails, Integer> {

    //Finding eligible archival cases could be done using this below query or you can also use derived queries (just like findByCaseStatusAndUpdatedDateBefore method)
//    @Query("""
//        SELECT c FROM CaseDetails c
//        WHERE c.caseStatus = :status
//        AND c.updatedDate < :cutOffDate
//    """)
//    public List<CaseDetails> getArchivalCases(String status, LocalDateTime cutOffDate);

    public List<CaseDetails> findByCaseStatusAndUpdatedDateBefore(String status, LocalDateTime cutOffDate);

    List<CaseDetails> findByStatus(Status status);

    @Transactional("primaryDbTransactionManager")
    @Modifying
    @Query("""
            UPDATE CaseDetails c
            SET c.status = 'PICKED_FOR_ARCHIVAL',
                c.updatedDate = CURRENT_TIMESTAMP
            WHERE c.caseId = :caseId AND c.status = 'ACTIVE'
            """)
    int markAsArchive(@Param("caseId") int caseId);
}
