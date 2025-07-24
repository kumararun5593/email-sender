package com.nagarro.email_sender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	EmailService emailService;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public ResponseEntity<?> sendEmail() throws MessagingException {
		MimeMessage mimeMessgae= javaMailSender.createMimeMessage();
		MimeMessageHelper helper= new MimeMessageHelper(mimeMessgae, true);
		String emailBody = getEmailBody();
		helper.setTo("dummy.psm.user@gamil.com");
		helper.setSubject("Modify UCIC Mapping!");
		helper.setText(emailBody, true);
		emailService.sendEmail(mimeMessgae);
		System.out.println("Confirmation Token: King@123");
		return ResponseEntity.ok("Verify email by the link sent on your email address");
	}

	private String getEmailBody() {
		String emailBody= "<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Approve and Reject Buttons</title>\r\n"
				+ "	<style>\r\n"
				+ "	table, th, td {\r\n"
				+ "  border: 1px solid black;\r\n"
				+ "  border-collapse: collapse;\r\n"
				+ "}\r\n"
				+ "	</style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "</br>\r\n"
				+ "<p>Dear Recipent,</p>\r\n"
				+ "<p>UCIC master mapping is modified and pending for your approval, please take action as earliest.</p>\r\n"
				+ "<table >\r\n"
				+ "        <tr>\r\n"
				+ "            <th style=\"background-color: #e1bfc9  ; color: maroon;\">UCIC</th>\r\n"
				+ "            <th style=\"background-color: #e1bfc9  ; color: maroon;\">Corporate Name</th>\r\n"
				+ "            <th style=\"background-color: #e1bfc9  ; color: maroon;\">PSM Name</th>\r\n"
				+ "			<th style=\"background-color: #e1bfc9  ; color: maroon;\">PSM Employee ID</th>\r\n"
				+ "            <th style=\"background-color: #e1bfc9  ; color: maroon;\">IM Employee ID</th>\r\n"
				+ "            <th style=\"background-color: #e1bfc9  ; color: maroon;\">IM Name</th>\r\n"
				+ "			<th style=\"background-color: #e1bfc9  ; color: maroon;\">Segment</th>\r\n"
				+ "        </tr>\r\n"
				+ "        <tr>\r\n"
				+ "            <td>102874437483</td>\r\n"
				+ "            <td>Maria Anders</td>\r\n"
				+ "            <td>Germany</td>\r\n"
				+ "			 <td>Alfreds Futterkiste</td>\r\n"
				+ "            <td>Maria Anders</td>\r\n"
				+ "            <td>Germany</td>\r\n"
				+ "			<td>Germany</td>\r\n"
				+ "        </tr>\r\n"
				+ "    </table>\r\n"
				+ "	</br>\r\n"
				+ "	</br>\r\n"
				+ "	\r\n"
				+ "	<table>\r\n"
				+ "	<tr>\r\n"
				+ "	<td>\r\n"
				+ "    <a href=\"mailto:ifo.arun@gmail.com?subject=Modify%20UCIC%20Mapping&body=Dear%20Sender%2C%0A%0APlease%20find%20my%20action%20for%20the%20request%20sent%20to%20me.%0A%0AAction%20taken-%20%0ARemarks%20%20%20%20%20%20%20-%20%0A%0A%0AThanks%20and%20Regards!%0A{userName}%0A%0AAuthorization%20code%20-%20\" style=\"text-decoration: none;\">\r\n"
				+ "        <button style=\"background-color: green; color: white; padding: 10px 20px; border: none; cursor: pointer;\">Approve</button>\r\n"
				+ "    </a>\r\n"
				+ "	</td><td>\r\n"
				+ "    <a href=\"mailto:ifo.arun@gmail.com?subject=Modify%20UCIC%20Mapping&body=Dear%20Sender%2C%0A%0APlease%20find%20my%20action%20for%20the%20request%20sent%20to%20me.%0A%0AAction%20taken-%20%0ARemarks%20%20%20%20%20%20%20-%20%0A%0A%0AThanks%20and%20Regards!%0A{userName}%0A%0AAuthorization%20code%20-%20\" style=\"text-decoration: none;\">\r\n"
				+ "        <button style=\"background-color: red; color: white; padding: 10px 20px; border: none; cursor: pointer;\">Reject</button>\r\n"
				+ "    </a>\r\n"
				+ "	</td>\r\n"
				+ "	</tr>\r\n"
				+ "	</table>\r\n"
				+ "	</br></br>\r\n"
				+ "	<p>Thankyou!</p>\r\n"
				+ "	<p>Admin</p>\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ "";
		return emailBody;
	}

}
