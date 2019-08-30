package com.LTR.configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component("passwordCreator")
public class PasswordCreator extends BCryptPasswordEncoder{
	
    public static final String justin9ucr = "$2a$10$hswtKpshrEeFKyZ9lnOhke01FMeChcYd9p66vr7Sx/STl3Rynfcse";
    
	public String EncodePass(String password){
		return encode(password);
	}

}
