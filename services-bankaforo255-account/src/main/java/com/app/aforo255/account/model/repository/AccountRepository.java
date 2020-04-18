package com.app.aforo255.account.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.aforo255.account.model.entity.Account;
@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

}
