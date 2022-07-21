package com.example.demo.Registration;

import java.util.function.Predicate;

import org.springframework.stereotype.Service;
@Service
public class EmailValidation implements Predicate<String>{

	@Override
	public boolean test(String t) {
		//todo: regex to validate email
		return true;
	}

}
