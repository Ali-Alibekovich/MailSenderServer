package com.example.mailsender;

import com.example.mailsender.config.MailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Map;

@Component
public class Jms2MailListener {

    @Value("${mail.login}")
    String MY_EMAIL;

    @Autowired
    MailConfig mailConfig;

    @JmsListener(destination = "mail")
    public void receiveQaMessage(String mail) throws MessagingException {


        Message msg = new MimeMessage(mailConfig.getSession());
        msg.setFrom(new InternetAddress(MY_EMAIL));
        InternetAddress[] addresses = {new InternetAddress(mail)};
        msg.setRecipients(Message.RecipientType.TO, addresses);
        msg.setSubject("Thanks for the purchase");
        msg.setSentDate(new Date());
        msg.setText("You have recently placed an order on the website. Thank you for staying with us!");
        Transport.send(msg);
    }
}
