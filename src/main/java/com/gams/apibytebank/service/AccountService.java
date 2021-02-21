package com.gams.apibytebank.service;

import com.gams.apibytebank.model.Account;
import com.gams.apibytebank.repository.AccountRepository;
import com.gams.apibytebank.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository repo;

    public Account search(Integer id) {
        Optional<Account> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Account.class.getName()));
    }
}
