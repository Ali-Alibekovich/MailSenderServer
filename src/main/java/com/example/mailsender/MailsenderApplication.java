package com.example.mailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class MailsenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailsenderApplication.class, args);
    }

}
