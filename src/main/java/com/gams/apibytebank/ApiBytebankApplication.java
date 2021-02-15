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

        Account acc1 = new Account(null,2970 , 800.00, cli1);
        Account acc2 = new Account(null, 0007, 8000.00, cli2);

        cli1.setAccounts(Arrays.asList(acc1));
        cli2.setAccounts(Arrays.asList(acc2));


//        System.out.println(acc1);
//        System.out.println(acc2);
//        System.out.println("CONTASSSSSSS:"+ cli1.getAccounts());

        accountRepository.saveAll(Arrays.asList(acc1,acc2));
        clientRepository.saveAll(Arrays.asList(cli1, cli2));




    }
}
