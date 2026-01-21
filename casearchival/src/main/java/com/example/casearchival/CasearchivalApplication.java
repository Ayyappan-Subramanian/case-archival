package com.example.casearchival;

import com.example.casearchival.model.CaseDetails;
import com.example.casearchival.repository.CaseArchivalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class CasearchivalApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CasearchivalApplication.class, args);

//		CaseDetails case1 = context.getBean(CaseDetails.class);
//		CaseDetails case2 = context.getBean(CaseDetails.class);
//		case1.setCaseId(02);
//		case1.setCaseType("Unauthorized ACH");
//		case1.setCaseStatus("Pending");
//		case1.setCreatedDate(LocalDateTime.now());
//		case1.setUpdatedDate(LocalDateTime.now());
//
//		CaseArchivalRepo repo = context.getBean(CaseArchivalRepo.class);
//
//		repo.save(case1);

		//List<CaseDetails> l = repo.findAll();
		//System.out.println(l);

	//for(CaseDetails c : l)
		//System.out.println(c);

		System.out.println("Iam Here");
		//System.out.println(case1.getCaseId());
	}

}
