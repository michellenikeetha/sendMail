package com.example.sendEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/mail")
@RestController
public class MailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/send")

    public String sendEmail(@RequestBody MailDetailsDTO mailDetailsDTO){

        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject(mailDetailsDTO.getSubject());
            message.setTo(mailDetailsDTO.getToMail());
            message.setFrom("michellenikeetha@gmail.com");
            message.setText(mailDetailsDTO.getMessage());

            javaMailSender.send(message);
            System.out.println(message.toString());

            return "Success";
        } catch (Exception e){
            return e.getMessage();
        }

    }
}
