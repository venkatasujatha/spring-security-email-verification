package com.example.demo.Registration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Registration.token.ConfirmationToken;
@RestController
@RequestMapping(path = "/api/v1/registration")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping("/add")
	public String register(@RequestBody RegistrationRequest request)
	{
		return registrationService.register(request);
	}
	@GetMapping("/confirm/{token}")
	public Optional<ConfirmationToken> confirm(@PathVariable String token)
	{
		return registrationService.confirmToken(token);
	}
}
