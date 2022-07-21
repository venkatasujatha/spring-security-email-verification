package com.example.demo.Registration.token;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfirmationTokenService {
	
	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;
	
	public void saveConfirmationToken(ConfirmationToken confirmationToken)
	{
		confirmationTokenRepository.save(confirmationToken);
	}

	public Optional<ConfirmationToken> findByToken(String token) {
		
		return confirmationTokenRepository.findByToken(token);
	}

}
