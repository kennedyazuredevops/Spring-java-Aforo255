package com.app.aforo255.historical.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.aforo255.historical.model.entity.Transaction;
import com.app.aforo255.historical.model.repository.TransactionRepository;
@Service
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	private TransactionRepository repository;
	
	@Override
	public Transaction save(Transaction transaction) {
		// TODO Auto-generated method stub
		return repository.save(transaction);
	}

	@Override
	public Iterable<Transaction> findByAccountId(Integer accountId) {
		// TODO Auto-generated method stub
		return repository.findByAccountId(accountId);
	}

	@Override
	public Iterable<Transaction> findAdll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
