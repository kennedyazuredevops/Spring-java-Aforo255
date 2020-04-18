package com.app.aforo255.historical.kafka.consumer.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.app.aforo255.historical.service.TransactionEvents;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class TransactionEventsConsumer {

	@Autowired
	private TransactionEvents transactionEvents;
	private Logger log =LoggerFactory.getLogger(TransactionEventsConsumer.class) ;
	@KafkaListener(topics= {"transaction-events"})
	public void onMessage(ConsumerRecord<Integer,String> consumerRecord) throws  JsonProcessingException {
		
		log.info("ConsumerRecord account : {} ",consumerRecord);
		transactionEvents.processTransactionEvent(consumerRecord);
		
	}
	
}
