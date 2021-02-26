package com.wholesale.anz.api.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wholesale.anz.api.services.AccountTransactionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/transactions")
@Slf4j
public class AccountTransactionController {

	@Autowired AccountTransactionService accountsTransactionsService;

	// Get Transaction List By Account Number
    @GetMapping("/{accountNumber}")
    public ResponseEntity<List<?>> getAccountsTransactionsById(@PathVariable String accountNumber) {
        return ResponseEntity.ok(accountsTransactionsService.findAccountTransactionsByAccountNumber(accountNumber));
    }
}
