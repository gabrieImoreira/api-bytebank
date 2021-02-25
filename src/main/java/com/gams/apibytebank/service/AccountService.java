package com.gams.apibytebank.service;

import com.gams.apibytebank.controller.dto.AccountDto;
import com.gams.apibytebank.controller.dto.AccountNewDto;
import com.gams.apibytebank.model.Account;
import com.gams.apibytebank.model.Client;
import com.gams.apibytebank.repository.AccountRepository;
import com.gams.apibytebank.service.exceptions.DataIntegrityException;
import com.gams.apibytebank.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository repo;

    @Transactional
    public Account insert(Account obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Account search(Integer id) {
        Optional<Account> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Account.class.getName()));
    }

    public Account update(Account obj) {
        Account newObj = search(obj.getId()); //verify if exists id
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        search(id);
        try {
            repo.deleteById(id);
        }
        catch(DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir pq há entidades relacionadas");
        }
    }

    public Account fromDTO(AccountDto objDto) {
        return new Account(objDto.getId(), objDto.getNumber(), objDto.getBalance(), null);
    }

    public Account fromDTO(AccountNewDto objDto) {
        return new Account(null, objDto.getNumber(), objDto.getBalance(), objDto.getClient());

    }

    private void updateData(Account newObj, Account obj) {
        newObj.setNumber(obj.getNumber());
        newObj.setBalance(obj.getBalance());

    }


}
