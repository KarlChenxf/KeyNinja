package com.xfchen.mySite.utility;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.xfchen.mySite.domain.User;

@Component
public class MailConstructor {

	@Autowired
	private Environment env;

	public SimpleMailMessage constructResetTokenEmail(String appUrl, Locale locale, String token, User user,
			String password) {
		String url = appUrl + "/newAccount?token=" + token;
		String message = "\n Please click on below link to verify your email and update your personal information. \n Your password is: \n"
				+ password + "\n";
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setSubject("CXF's NasoStore - Registration");
		email.setText(message + url);
		email.setFrom(env.getProperty("support.email"));
		return email;
	}

}
