package com.gams.apibytebank.controller.dto;

import com.gams.apibytebank.model.Account;
import com.gams.apibytebank.model.Client;
import com.gams.apibytebank.model.enums.TypeClient;
import com.gams.apibytebank.repository.ClientRepository;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class ClientDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String name;
    private String cpfOrCnpj;

    @NotEmpty(message="Preenchimento obrigatório")
    @Email
    private String email;
    private String occupation;
    private TypeClient type;
    private List<Integer> account;
    
    
    public ClientDto(Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.cpfOrCnpj = client.getCpfOrCnpj();
        this.email = client.getEmail();
        this.occupation = client.getOccupation();
        this.type = client.getType();
        this.account = client.getAccounts().stream().map(Account::getId).collect(Collectors.toList()); //restore account id
    }

    public ClientDto() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpfOrCnpj() {
        return cpfOrCnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getOccupation() {
        return occupation;
    }

    public TypeClient getType() {
        return type;
    }

    public List <Integer> getAccount() {
        return account;
    }

        public static List<ClientDto> convert(List<Client> clients) {
        return clients.stream().map(ClientDto::new).collect(Collectors.toList());
    }
}
