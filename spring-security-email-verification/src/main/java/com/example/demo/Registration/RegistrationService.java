package com.example.demo.Registration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Registration.mail.EmailSender;
import com.example.demo.Registration.token.ConfirmationToken;
import com.example.demo.Registration.token.ConfirmationTokenService;
import com.example.demo.appuser.AppUser;
import com.example.demo.appuser.AppUserRole;
import com.example.demo.appuserservice.AppUserService;

@Service
public class RegistrationService {

	
	@Autowired
	private EmailValidation emailValidation;
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private ConfirmationTokenService confirmationTokenService;
	
	@Autowired
	private EmailSender emailSender;
	
	public String register(RegistrationRequest request) {
		boolean isValidEmail = emailValidation.test(request.getEmail());
		if(!isValidEmail)
		{
			throw new IllegalStateException("email not valid");
		}
		return appUserService.SignUpUser(
				new AppUser(
						request.getFirstname(),
				request.getLastname(),
				request.getEmail(),
				request.getPassword(),
				AppUserRole.USER
				));
		
	}

	public Optional<ConfirmationToken> confirmToken(String token) {
		
		
		return appUserService.confirmToken(token);
	}
	
	
}
