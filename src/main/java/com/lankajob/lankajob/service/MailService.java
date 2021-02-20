package com.lankajob.lankajob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
    private JavaMailSender javaMailSender;
	
	public void sendNewMail(String toMail, String subject,String msgBody) {

        SimpleMailMessage msg = new SimpleMailMessage();
        
        msg.setFrom("scar2018001@gmail.com");
        msg.setTo(toMail);
        msg.setSubject(subject);
        msg.setText(msgBody);

        javaMailSender.send(msg);
        System.out.println("-----------------------Mail Send----------------------");

    }
	
}
