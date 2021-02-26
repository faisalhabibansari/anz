package com.wholesale.anz.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wholesale.anz.api.entities.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
    public List<AccountTransaction> findAccountTransactionsByAccountNumber(String accountNumber);
}
