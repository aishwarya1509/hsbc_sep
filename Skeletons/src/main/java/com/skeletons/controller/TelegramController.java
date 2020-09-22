package com.skeletons.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.skeletons.service.TelegramService;
import com.skeletons.service.TelegramServiceInterface;
import com.skeletons.telegram.entity.TelegramUser;

public class TelegramController implements TelegramControllerInterface {
private TelegramServiceInterface ts;
	
	public TelegramController() {
		ts=new TelegramService();
		
	}
	
	@Override
	public void createProfile() throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your Name : ");
		String name=br.readLine();
		
		System.out.println("Enter your Password : ");
		String password=br.readLine();
		
		System.out.println("Enter your Email : ");
		String email=br.readLine();
		
		System.out.println("Enter your Address : ");
		String address=br.readLine();
		
		TelegramUser tu=new TelegramUser();
		tu.setName(name);
		tu.setPassword(password);
		tu.setEmail(email);
		tu.setAddress(address);
		
		
		int i=ts.createProfileService(tu);
		
		if(i>0) {
			System.out.println("Profile created");
		}
		else {
			System.out.println("Sorry Could not create profile");
		}
	
		
	}

	@Override
	public void editProfile() {
		ts.editProfileService();
		System.out.println("profile edited");
		
	}

	@Override
	public void deleteProfile() {
		ts.deleteProfileService();
		System.out.println("profile deleted");
		
	}

	@Override
	public void viewProfile() {
		ts.viewProfileService();
		System.out.println("profile detail");
		
	}


}
