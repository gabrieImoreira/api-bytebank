package com.gams.apibytebank.controller;

import com.gams.apibytebank.model.Account;
import com.gams.apibytebank.model.Client;
import com.gams.apibytebank.model.enums.TypeClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="account")
public class AccountsController {

    @RequestMapping
    public List<Account> toList(){

        Client cli1 = new Client(null, "Robert A Heinlein", "48795782", "robert@boostrap.com","Writer", TypeClient.PF);
        Client cli2 = new Client(null, "Linus Torvalds", "79848", "linus@mint.com","Programmer", TypeClient.PJ);

        Account acc1 = new Account(null,2970 , 800.00, cli1);
        Account acc2 = new Account(null, 0007, 8000.00, cli2);

        List<Account> list = new ArrayList<>();
        list.add(acc1);
        list.add(acc2);
        return list;
    }
}
