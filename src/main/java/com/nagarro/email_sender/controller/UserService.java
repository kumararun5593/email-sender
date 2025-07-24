package com.nagarro.email_sender.controller;

import org.springframework.http.ResponseEntity;

import jakarta.mail.MessagingException;

public interface UserService {

	ResponseEntity<?> sendEmail() throws MessagingException;

}
