package com.flipkart.service;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.User;
import com.flipkart.dao.UserDao;
import com.flipkart.dao.UserDaoImpl;
import com.flipkart.exception.LoginException;

public class UserOperation implements UserInterface{
	
	private static Logger logger = Logger.getLogger(UserOperation.class);

	// Checking Identity.
	
	@Override
	public String checkIdentity (User user) throws LoginException  {
		
		String s="";
		
			UserDao userdao = new UserDaoImpl();
			 s= userdao.checkIdentity(user);
			 
		if(user.getUserId()==-1)
			throw new LoginException();
		
		return s;
		
	}

//	// Registering a new user.
//	@Override
//	public void registerUser(User user) {
//		
//		try {
//			logger.info("Enter the userId");
//			Scanner sc = new Scanner(System.in);
//			int userId = sc.nextInt();
//			user.setUserId(userId);
//			
//			logger.info("Enter your password");
//			String password = sc.nextLine();
//			user.setPassword(password);
//			
//			logger.info("Enter the userName");
//			String userName = sc.nextLine();
//			user.setUserName(userName);
//			
//			logger.info("What's your role");
//			String role = sc.nextLine();
//			user.setRole(role);
//			
//			UserDao userdao = new UserDaoImpl();
//			userdao.registerUser(user);
//			
//		}
//		catch(Exception e) {
//			//logger.error(e.viewLog());
//			e.printStackTrace();
//		}
//		
//		
//	}

}

//UserDao userdao = new UserDaoImpl();
//public void login(User user) {
//try
//{
//userdao.login(user);
//}
//catch(Exception e)
//{
//
//}
//}