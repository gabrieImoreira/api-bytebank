package com.gams.apibytebank;

import com.gams.apibytebank.model.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ApiBytebankApplication {

    @RequestMapping("/")
    String home(){
        return "Hello World, here you will find a" +
                " API simulating one bank interface, enjoy :)";
    }
    public static void main(String[] args) {
        SpringApplication.run(ApiBytebankApplication.class, args);
    }

    Client client = new Client();
}
