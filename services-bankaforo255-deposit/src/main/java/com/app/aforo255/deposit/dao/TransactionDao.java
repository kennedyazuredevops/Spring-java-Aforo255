package com.app.aforo255.deposit.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.aforo255.deposit.domain.Transaction;

public interface TransactionDao extends CrudRepository<Transaction, Integer>{

	
}
