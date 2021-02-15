package com.gams.apibytebank.controller;

import com.gams.apibytebank.controller.dto.AccountDto;
import com.gams.apibytebank.model.Account;
import com.gams.apibytebank.model.Client;
import com.gams.apibytebank.model.enums.TypeClient;
import com.gams.apibytebank.repository.AccountRepository;
import com.gams.apibytebank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;


    @RequestMapping(value="account")
    public List<AccountDto> toList(){
        Client cli1 = new Client(1, "Robert A Heinlein", "48795782", "robert@boostrap.com","Writer", TypeClient.PF);
        Client cli2 = new Client(2, "Linus Torvalds", "79848", "linus@mint.com","Programmer", TypeClient.PJ);

        Account acc1 = new Account(1,2970 , 800.00, cli1);
        Account acc2 = new Account(3, 0007, 8000.00, cli2);


        return AccountDto.convert(Arrays.asList(acc1, acc2));

    }
}
