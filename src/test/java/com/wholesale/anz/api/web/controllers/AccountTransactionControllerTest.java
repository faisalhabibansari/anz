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
import com.wholesale.anz.api.entities.AccountTransaction;
import com.wholesale.anz.api.services.AccountTransactionService;

@WebMvcTest(controllers = AccountTransactionController.class)
@ActiveProfiles("test")
class AccountTransactionControllerTest {

    @Autowired private MockMvc mockMvc;

    @MockBean private AccountTransactionService accountTransactionService;

    @Autowired private ObjectMapper objectMapper;

    private List<AccountTransaction> accountTransactionList;

    @BeforeEach
    void setUp() {
        this.accountTransactionList = new ArrayList<>();
        this.accountTransactionList.add(new AccountTransaction(7L, "1245631215","USDSavings459",new Date(),"USD", 0.0,500.0,"Credit",""));
        this.accountTransactionList.add(new AccountTransaction(8L, "1245631215","USDSavings459",new Date(),"USD", 0.0,200.0,"Credit",""));
        this.accountTransactionList.add(new AccountTransaction(9L, "1245631215","USDSavings459",new Date(),"USD", 0.0,900.0,"Credit",""));

        objectMapper.registerModule(new ProblemModule());
        objectMapper.registerModule(new ConstraintViolationProblemModule());
    }


    @Test
    void shouldFindAccountTransactionsByAccountNumber() throws Exception {
        String accountNumber="1245631215";
        given(accountTransactionService.findAccountTransactionsByAccountNumber(accountNumber)).willReturn(this.accountTransactionList);
        this.mockMvc
                .perform(get("/api/transactions/{accountNumber}", accountNumber))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(accountTransactionList.size())));
    }

}
