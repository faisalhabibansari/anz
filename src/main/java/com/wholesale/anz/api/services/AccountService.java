package com.wholesale.anz.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wholesale.anz.api.entities.Account;
import com.wholesale.anz.api.repositories.AccountRepository;

@Service
public class AccountService {

	@Autowired AccountRepository accountsRepository;

	// Get All accounts from Account Repository
    public List<Account> findAllAccounts() {
        return accountsRepository.findAll();
    }

}
