package com.app.aforo255.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.aforo255.account.model.entity.Account;
import com.app.aforo255.account.model.entity.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.*;

@Service
public class TransactionEvents {

	private Logger log = LoggerFactory.getLogger(TransactionEvents.class);
	@Autowired
	private IAccountService repository;
	@Autowired
	ObjectMapper objectMapper;

	public void processTransacctionEvent(ConsumerRecord<Integer, String> consumerRecord)
			throws JsonMappingException, JsonProcessingException {
		double newmonto = 0;
		Account objAccount = new Account();
		Transaction transactionEvent = objectMapper.readValue(consumerRecord.value(), Transaction.class);
		log.info("transactionEvent : {} ", transactionEvent.getAccountId());
		objAccount = repository.findById(transactionEvent.getAccountId());
		log.info("get amout : ", objAccount.getTotalAmount());

		switch (transactionEvent.getType()) {
		case "deposito":
			newmonto = objAccount.getTotalAmount() + transactionEvent.getAmount();
			break;
		case "retiro":
			newmonto = objAccount.getTotalAmount() - transactionEvent.getAmount();
			break;
		default:
			log.info("Invalid Library Event type");
		}
		
		log.info("set new amount {}",newmonto);
		objAccount.setTotalAmount(newmonto);
		repository.save(objAccount);
	}

}
