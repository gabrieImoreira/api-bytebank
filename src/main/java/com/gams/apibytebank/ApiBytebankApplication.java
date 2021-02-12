package com.gams.apibytebank;

import com.gams.apibytebank.model.Account;
import com.gams.apibytebank.model.Client;
import com.gams.apibytebank.model.enums.TypeClient;
import com.gams.apibytebank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

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

    public static void main(String[] args) {
        SpringApplication.run(ApiBytebankApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {



        Client cli1 = new Client(null, "Ricardo", "4828", "ric@nubank.com","Programador", TypeClient.PF);
        Client cli2 = new Client(null, "Messias", "4828", "ric@nubank.com","Empresário", TypeClient.PJ);

        clientRepository.saveAll(Arrays.asList(cli1, cli2));

    }
}
