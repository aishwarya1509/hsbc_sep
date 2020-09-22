package com.skeletons.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.skeletons.linkedin.entity.LinkedinUser;
import com.skeletons.service.LinkedinService;
import com.skeletons.service.LinkedinServiceInterface;

public class LinkedinController implements LinkedinControllerInterface{
	
private LinkedinServiceInterface ls;
	
	public LinkedinController(){
		ls=new LinkedinService();
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
		
		LinkedinUser lu=new LinkedinUser();
		lu.setName(name);
		lu.setPassword(password);
		lu.setEmail(email);
		lu.setAddress(address);
		
		
		int i=ls.createProfileService(lu);
		
		if(i>0) {
			System.out.println("Profile created");
		}
		else {
			System.out.println("Sorry Could not create profile");
		}
	
	}

	@Override
	public void editProfile() {
		ls.editProfileService();
		System.out.println("profile edited");
		
	}

	@Override
	public void deleteProfile() {
		ls.deleteProfileService();
		System.out.println("profile deleted");
		
	}

	@Override
	public void viewProfile() {
		ls.viewProfileService();
		System.out.println("profile detail");
		
	}



}
