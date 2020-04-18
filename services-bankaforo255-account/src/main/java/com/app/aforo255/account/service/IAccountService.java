package com.app.aforo255.account.service;

import java.util.List;

import com.app.aforo255.account.model.entity.Account;

public interface IAccountService {

	public List<Account> findAll();
	public Account findById(Integer id);
	public Account save(Account account);
	
}
