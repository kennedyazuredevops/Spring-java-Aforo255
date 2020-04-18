package com.app.aforo255.historical.service;

import com.app.aforo255.historical.model.entity.Transaction;

public interface ITransactionService {

	public Transaction save (Transaction transaction);
	public Iterable <Transaction> findByAccountId(Integer accountId);
	public Iterable<Transaction> findAdll();
}
