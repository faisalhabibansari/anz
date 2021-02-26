package com.wholesale.anz.api.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//AccountTransaction Entity
@Entity
@Table(name = "accounts_transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "accountNumber", nullable = false)
    private String accountNumber;

    @Column(name = "accountName", nullable = false)
    private String accountName;

    @Column(name = "valueDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date valueDate;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "debitAmount", nullable = false)
    private Double debitAmount;

    @Column(name = "creditAmount", nullable = false)
    private Double creditAmount;

    @Column(name = "debitOrCredit", nullable = false)
    private String debitOrCredit;

    @Column(name = "transactionNarrative", nullable = false)
    private String transactionNarrative;
}
