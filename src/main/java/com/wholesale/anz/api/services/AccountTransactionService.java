package com.wholesale.anz.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wholesale.anz.api.entities.AccountTransaction;
import com.wholesale.anz.api.repositories.AccountTransactionRepository;

@Service
public class AccountTransactionService {

	
	 @Autowired AccountTransactionRepository accountsTransactionsRepository;
	
	 // Get All transaction of an account number from AccountTransaction repository
	  public List<AccountTransaction> findAccountTransactionsByAccountNumber(String accountNumber)
	  {
	  return accountsTransactionsRepository.findAccountTransactionsByAccountNumber(accountNumber); 
	  }
	 
}
