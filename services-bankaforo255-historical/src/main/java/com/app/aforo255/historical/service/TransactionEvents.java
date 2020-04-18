package com.app.aforo255.historical.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.aforo255.historical.model.entity.Transaction;
import com.app.aforo255.historical.model.repository.TransactionRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.*;
@Service
public class TransactionEvents {

	private Logger log = LoggerFactory.getLogger(TransactionEvents.class);
	@Autowired
	private TransactionRepository repository;
	@Autowired
	ObjectMapper objectMapper;

	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {

		Transaction transactionEvent = objectMapper.readValue(consumerRecord.value(), Transaction.class);
		log.info("transactionEvent : {} ", transactionEvent);
		repository.save(transactionEvent);
		log.info("Successfully Persisted the transaction Event {} ",transactionEvent);
	}
}
