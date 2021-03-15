package com.gams.apibytebank.controller.dto;

import com.gams.apibytebank.model.Client;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class AccountNewDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message="Preenchimento obrigatório")
    private Integer number;

    @NotNull(message="Preenchimento obrigatório")
    private Double balance;

    @NotNull
    private Client client;


    public AccountNewDto() {
    }

    public AccountNewDto(Integer number, Double balance, Client client) {
        this.number = number;
        this.balance = balance;
        this.client = client;
    }                                       

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }
}
