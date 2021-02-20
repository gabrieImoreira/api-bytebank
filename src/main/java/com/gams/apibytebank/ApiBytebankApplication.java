package com.gams.apibytebank;

import com.gams.apibytebank.model.Account;
import com.gams.apibytebank.model.Client;
import com.gams.apibytebank.model.enums.TypeClient;
import com.gams.apibytebank.repository.AccountRepository;
import com.gams.apibytebank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@SpringBootApplication
public class ApiBytebankApplication implements CommandLineRunner {

    @RequestMapping("/")
    String home(){
        return "Hello World, here you will find a" +
                " API simulating one bank interface, enjoy :)";
    }

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(ApiBytebankApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {



        Client cli1 = new Client(null, "Robert A Heinlein", "48795782", "robert@boostrap.com","Writer", TypeClient.PF);
        Client cli2 = new Client(null, "Linus Torvalds", "79848", "linus@mint.com","Programmer", TypeClient.PJ);
        Client cli3 = new Client(null, "George Hotz", "1234567", "geohot@siemens.com","Software Dev", TypeClient.PJ);
        Client cli4 = new Client(null, "Gabriel Moreira", "4444", "gams@tesla.com","Engineer", TypeClient.PF);
        Client cli5 = new Client(null, "Ana Beatriz", "121416", "anab@fox.com","Physicist", TypeClient.PJ);


        Account acc1 = new Account(null,2970 , 800.00, cli1);
        Account acc2 = new Account(null, 0007, 8000.00, cli2);
        Account acc3 = new Account(null, 1993, 869.20, cli3);
        Account acc4 = new Account(null, 4312, 1268468.95, cli4);
        Account acc5 = new Account(null, 1234, 8.00, cli4);
        Account acc6 = new Account(null, 1597, 126712.10, cli4);
        Account acc7 = new Account(null, 593, 826862.07, cli2);
        Account acc8 = new Account(null, 516, 3200.00, cli3);
        Account acc9 = new Account(null, 1012, 12000.51, cli5);


        cli1.getAccounts().addAll(Arrays.asList(acc1));
        cli2.getAccounts().addAll(Arrays.asList(acc2, acc7));
        cli3.getAccounts().addAll(Arrays.asList(acc3, acc8));
        cli4.getAccounts().addAll(Arrays.asList(acc4, acc5, acc6));
        cli5.getAccounts().addAll(Arrays.asList(acc9));

        clientRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5));
        accountRepository.saveAll(Arrays.asList(acc1, acc2, acc3, acc4, acc5, acc6, acc7, acc8, acc9));





    }
}
