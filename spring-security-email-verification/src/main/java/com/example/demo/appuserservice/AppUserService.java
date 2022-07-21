package com.example.demo.appuserservice;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Registration.token.ConfirmationToken;
import com.example.demo.Registration.token.ConfirmationTokenService;
import com.example.demo.Repository.AppUserRepository;
import com.example.demo.appuser.AppUser;
@Service
public class AppUserService implements UserDetailsService{

	@Autowired
	private AppUserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private ConfirmationTokenService confirmationTokenService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		return repository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("user with email %s is not found"));
	}

	public String SignUpUser(AppUser appUser)
	{
		boolean userExists = repository.findByEmail(appUser.getEmail()).isPresent();
		if(userExists)
		{
			throw new IllegalStateException("email already taken");
		}
		
		String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());
		
		appUser.setPassword(encodedPassword);
		repository.save(appUser);
		
		String token = UUID.randomUUID().toString();
		
		//todo: send confirmation token
		
		ConfirmationToken token2=new ConfirmationToken(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(15), appUser);
		confirmationTokenService.saveConfirmationToken(token2);
		
		//todo: send email
		
		return token;
	}

	public Optional<ConfirmationToken> confirmToken(String token) {
		
		
		return confirmationTokenService.findByToken(token);
	}
}
