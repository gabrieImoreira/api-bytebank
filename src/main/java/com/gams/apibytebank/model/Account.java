package com.gams.apibytebank.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Double balance;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;

    public Account() {
    }

    public Account(Long id, Integer number, Double balance, Client client) {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(number, account.number) && Objects.equals(balance, account.balance) && Objects.equals(client, account.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, balance, client);
    }
}
