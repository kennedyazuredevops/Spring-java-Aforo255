package com.app.aforo255.deposit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.aforo255.deposit.dao.TransactionDao;
import com.app.aforo255.deposit.domain.Transaction;
@Service 
public class TransactionSeviceImpl   implements ITransactionService {

	@Autowired
	private TransactionDao transactionDao;
	
	@Override
	@Transactional
	public Transaction save(Transaction transaction) {
		return transactionDao.save(transaction);
	}

}
