package com.wipro.userms.util;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class EncryptUtil {
	
	public static String[] getEncryptedPassword(String plainPassword,String salt)
	{ 
		
 
		if(salt==null)
		{
			salt= BCrypt.gensalt();
			System.out.println("salt="+salt);
		}
		
		String hashedPassword1 = BCrypt.hashpw(plainPassword, salt);
		System.out.println(hashedPassword1);
		String [] passwordSalt = {hashedPassword1,salt};
		return passwordSalt;
		
	}
	public static void main(String[] args) {
		System.out.println(getEncryptedPassword("pass123",null));
	}

}
