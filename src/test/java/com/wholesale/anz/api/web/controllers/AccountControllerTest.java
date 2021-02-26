package com.wholesale.anz.api.web.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.violations.ConstraintViolationProblemModule;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wholesale.anz.api.entities.Account;
import com.wholesale.anz.api.services.AccountService;

@WebMvcTest(controllers = AccountController.class)
@ActiveProfiles("test")
class AccountControllerTest {

    @Autowired private MockMvc mockMvc;

    @MockBean private AccountService accountsService;

    @Autowired private ObjectMapper objectMapper;

    private List<Account> accountList;

	
	  @BeforeEach void setUp() 
	  { 
	  this.accountList = new ArrayList<>();
	  this.accountList.add(new Account(4L, "1245631215","USDSavings459","Savings",new Date(),"USD", "14578.45")); 
	  this.accountList.add(new Account(5L, "8584542631","USDCurrent444","Current",new Date(),"USD", "78454.14")); 
	  this.accountList.add(new Account(6L, "5554873184","INRCurrent787","Current",new Date(),"INR", "4547451.79"));
	  
	  objectMapper.registerModule(new ProblemModule());
	  objectMapper.registerModule(new ConstraintViolationProblemModule()); 
	  }
	  
	  @Test void shouldFetchAllAccounts() throws Exception 
	  {
	  given(accountsService.findAllAccounts()).willReturn(this.accountList);
	  
	  this.mockMvc.perform(get("/api/accounts")) .andExpect(status().isOk()).andExpect(jsonPath("$.size()", is(accountList.size()))); 
	  } 
}
