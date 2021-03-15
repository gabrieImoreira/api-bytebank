package com.gams.apibytebank.controller.dto;

import com.gams.apibytebank.model.Account;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class AccountDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotNull(message="Preenchimento obrigatório")
    private Integer number;

    @NotNull(message="Preenchimento obrigatório")
    private Double balance;

    private Integer client;

    public AccountDto(Account account) {
        this.id = account.getId();
        this.number = account.getNumber();
        this.balance = account.getBalance();
        this.client = (account.getClient() == null) ? null : account.getClient();
    }

    public AccountDto(){

    }

    public Integer getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public Double getBalance() {
        return balance;
    }

    public Integer getClient() {
        return client;
    }

    public static List<AccountDto> convert(List<Account> accounts) {
        return accounts.stream().map(AccountDto::new).collect(Collectors.toList());
    }
}
