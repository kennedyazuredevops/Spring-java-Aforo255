package com.app.aforo255.deposit.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.aforo255.deposit.domain.Transaction;
import com.app.aforo255.deposit.producer.DepositEventProducer;
import com.app.aforo255.deposit.service.ITransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.slf4j.*;
@RestController
public class DepositEventsController {

	private Logger log = LoggerFactory.getLogger(DepositEventsController.class);
	@Autowired
	DepositEventProducer depositEventProducer;
	@Autowired
	private ITransactionService transactionService; 
	@PostMapping("/v1/depositEvent")
	public ResponseEntity<Transaction> postLibraryEvent(@RequestBody Transaction transactionEvent) throws JsonProcessingException{
		
		log.info("antes enviar tranSql ");
		Transaction tranSql = transactionService.save(transactionEvent);
		log.info("despues enviar tranSql ");
		log.info("antes sendDepositEvent_Approach3 ");
		depositEventProducer.sendDepositEvent_Approach3(tranSql);
		log.info("despues sendDepositEvent_Approach3 ");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(tranSql);
		
	}
	
}
