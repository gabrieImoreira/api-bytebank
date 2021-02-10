package com.gams.apibytebank.model;

import com.gams.apibytebank.model.enums.TypeClient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpfOrCnpj;
    private String password;
    private Integer type;

    public Client(){

    }
    public Client(Long id, String name, String cpfOrCnpj, String password, TypeClient type) {
        this.id = id;
        this.name = name;
        this.cpfOrCnpj = cpfOrCnpj;
        this.password = password;
        this.type = type.getCod();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpfOrCnpj() {
        return cpfOrCnpj;
    }

    public void setCpfOrCnpj(String cpfOrCnpj) {
        this.cpfOrCnpj = cpfOrCnpj;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TypeClient getType() {
        return TypeClient.toEnum(type);
    }

    public void setType(TypeClient type) {
        this.type = type.getCod();
    }
}

