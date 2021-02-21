package com.gams.apibytebank.controller.dto;

import com.gams.apibytebank.model.enums.TypeClient;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ClientNewDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message="Preenchimento obrigatório")
    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String name;

    @NotNull(message="Preenchimento obrigatório")
    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=30, message="O tamanho deve ser entre 5 e 30 caracteres")
    private String cpfOrCnpj;

    @Email
    private String email;

    @NotNull(message="Preenchimento obrigatório")
    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=40, message="O tamanho deve ser entre 5 e 40 caracteres")
    private String occupation;

    private Integer type;

    private ClientNewDto(){
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
