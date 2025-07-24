package com.nagarro.email_sender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;


@RestController
public class EmailSenderController {

	@Autowired
    private UserService userService;

    @PostMapping("/send/email")
    public ResponseEntity<?> registerUser() throws MessagingException  {
        return userService.sendEmail();
    }
}
