package com.gams.apibytebank.controller;

import com.gams.apibytebank.controller.dto.AccountDto;
import com.gams.apibytebank.model.Account;
import com.gams.apibytebank.repository.AccountRepository;
import com.gams.apibytebank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="account")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService service;

    @GetMapping
    public List<AccountDto> toList() {
        List<Account> accounts = accountRepository.findAll();
        return AccountDto.convert(accounts);
    }

    @GetMapping(value = "/{id}") //return dto
    public ResponseEntity<AccountDto> find(@PathVariable Integer id) { //@Path is to 'linkar' the id above
        Optional<Account> acc = Optional.ofNullable(service.search(id)); //connected with @AutowiredClient service above
        if (acc.isPresent()) {
            return ResponseEntity.ok(new AccountDto(acc.get())); //return the response and found obj
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
