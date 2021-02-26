package com.wholesale.anz.api.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wholesale.anz.api.entities.Account;
import com.wholesale.anz.api.services.AccountService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/accounts")
@Slf4j
public class AccountController {

	@Autowired AccountService accountsService;

	// Get List Of All Accounts
    @GetMapping
    public List<Account> getAllAccounts() {

    	return accountsService.findAllAccounts();
    }


}
