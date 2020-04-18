package com.app.aforo255.account.kafka.consumer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.app.aforo255.account.service.TransactionEvents;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class TransactionEventsConsumer {

	@Autowired
	private TransactionEvents transactionEvents;
	private Logger log =LoggerFactory.getLogger(TransactionEventsConsumer.class) ;
	@KafkaListener(topics= {"transaction-events"})
	public void onMessage(ConsumerRecord<Integer,String> consumerRecord) throws  JsonProcessingException {
		
		log.info("ConsumerRecord account : {} ",consumerRecord);
		transactionEvents.processTransacctionEvent(consumerRecord);
		
	}
	
}
