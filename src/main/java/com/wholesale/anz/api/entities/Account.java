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

//Account Entity
@Entity
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "accountNumber", nullable = false)
    private String accountNumber;

    @Column(name = "accountName", nullable = false)
    private String accountName;

    @Column(name = "accountType", nullable = false)
    private String accountType;

    @Column(name = "balanceDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date balanceDate;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "openingAvailableBalance", nullable = false)
    private String openingBalance;

}

