package com.naren.kadiri;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("Narendra") && password.equals("kadiri");
	}

}
