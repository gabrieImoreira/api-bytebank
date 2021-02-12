package com.gams.apibytebank.model;

import com.gams.apibytebank.model.enums.TypeClient;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpfOrCnpj;
    private String email;
    private String occupation;
    private Integer type;


    public Client(Long id, String name, String cpfOrCnpj, String email, String occupation, TypeClient type) {
        this.id = id;
        this.name = name;
        this.cpfOrCnpj = cpfOrCnpj;
        this.email = email;
        this.occupation = occupation;
        this.type = type.getCod();
    }

    public Client() {

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String password) {
        this.email = password;
    }

    public TypeClient getType() {
        return TypeClient.toEnum(type);
    }

    public void setType(TypeClient type) {
        this.type = type.getCod();
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(cpfOrCnpj, client.cpfOrCnpj) && Objects.equals(email, client.email) && Objects.equals(occupation, client.occupation) && Objects.equals(type, client.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cpfOrCnpj, email, occupation, type);
    }

    public String toString() {
        return "Informações do cliente, ID: " + this.id + ", nome: " + this.name + ", CPF/CNPJ: " +
                this.cpfOrCnpj + ", email: "  + this.email + ", ocupação: " + this.occupation +
                ", tipo do cliente: " + this.type + ".";
    }
}


