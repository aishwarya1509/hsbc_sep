package com.skeletons.controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.skeletons.facebook.entity.FacebookUser;
import com.skeletons.facebook.utility.FacebookException;
import com.skeletons.facebook.utility.ServiceFactory;
import com.skeletons.facebook.utility.SortBy_Address;
import com.skeletons.facebook.utility.SortBy_Email;
import com.skeletons.facebook.utility.SortBy_Name;
import com.skeletons.service.FacebookServiceInterface;


public class FacebookController implements FacebookControllerInterface {


	private FacebookServiceInterface fs;
	
	public FacebookController(){
		//fs=new FacebookService();
		fs=ServiceFactory.createObject("adminservice");
	}
	
	@Override
	public void createProfile() 
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
		System.out.println("Enter your Name : ");
		String name=br.readLine();
		
		System.out.println("Enter your Password : ");
		String password=br.readLine();
		
		System.out.println("Enter your Email : ");
		String email=br.readLine();
		
		System.out.println("Enter your Address : ");
		String address=br.readLine();
		
		FacebookUser fu=new FacebookUser();
		fu.setName(name);
		fu.setPassword(password);
		fu.setEmail(email);
		fu.setAddress(address);
		
		
		int i=fs.createProfileService(fu);
		
		if(i>0) {
			System.out.println("Profile created");
		}
		else {
			System.out.println("Sorry Could not create profile");
		}
		
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		
	}

	@Override
	public void editProfile() 
	{
		int k=1,i=0;
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
		System.out.println("Enter email if you want to edit profile: ");
		String email=br.readLine();
		 
		FacebookUser fu=new FacebookUser();
		fu.setEmail(email);
		
		/*fu.setAddress("");
		fu.setEmail("");*/
		
		i=fs.editProfileService(fu,k);
	
		if(i>0)
		{
			k=2;
			fu.setEmail(email);
			
			System.out.println("Enter Name: ");
			String name1=br.readLine();
			
			System.out.println("Enter new Password : ");
			String password1=br.readLine();
			
			
			System.out.println("Enter new address: ");
			String address=br.readLine();
			
			fu.setPassword(password1);
			fu.setName(name1);
			fu.setAddress(address);
			
			int j=fs.editProfileService(fu,k);
			
			System.out.println("Profile edited"+j);
	
		}
		
		else 
		{
			System.out.println("Sorry Could not edit profile");
		}
		
		}
		catch(IOException e1)
		{
		e1.printStackTrace();
		}
		
	}

	@Override
	public void deleteProfile() 
	{
		int i=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
		System.out.println("Enter Name you want to delete: ");
		String name=br.readLine();
		
		FacebookUser fu=new FacebookUser();
		fu.setName(name);
		
		  i = fs.deleteProfileService(fu);
		
		  if(i>0)
			{System.out.print("Item deleted");}
		  else
		  { System.out.print("Item not present"); }
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		
	}

	@Override
	public void viewProfile() 
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
		System.out.println("Enter your Name to view your profile: ");
		String name=br.readLine();
		
		FacebookUser fu=new FacebookUser();
		fu.setName(name);
		
		FacebookUser fu1 = fs.viewProfileService(fu);
		if(fu1!=null)
		{
			System.out.println("Name :" + fu1.getName());
			System.out.println("Password:"+ fu1.getPassword());
			System.out.println("Email:"+ fu1.getEmail());
			System.out.println("Adderss:"+fu1.getAddress());
		}
		else 
		{
			System.out.print("Not present");
		}
		
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		
	}

	@Override
	public void searchProfile()
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
		System.out.println("Enter your name to search profile: ");
		String name=br.readLine();
		   /* if(name.length()<3)
		    {  ////// user defined exception
		    	throw new FacebookException(name);
		    }*/
		FacebookUser fu=new FacebookUser();
		fu.setName(name);
		List<FacebookUser> flist= new ArrayList<FacebookUser>();
		flist = fs.searchProfileService(fu);

		System.out.println(flist.size()+"  users found");
		
		for(FacebookUser u:flist) {
			System.out.println("****************************************");
			System.out.println("Name is : "+u.getName());
			System.out.println("Password is : "+u.getPassword());
			System.out.println("Email is : "+u.getEmail());
			System.out.println("Address is : "+u.getAddress());
			System.out.println("****************************************");
		}
		}
		catch(IOException e1)
		{
			System.out.println(e1.toString());
		}
		catch(FacebookException e2)
		{
			System.out.println("Custom Exception Occured-----"+e2);
		}
		
	}

	@Override
	public void viewAllProfile() 
	{
		List<FacebookUser> uu=fs.viewallprofileService();
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		System.out.println("press 1 to Sort By Name");
		System.out.println("press 2 to Sort By Email");
		System.out.println("press 3 to Sort By Address");
		System.out.println("enter your choice ");
		int i=0;
		try {
			i = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		switch(i) 
		{
		
		case 1: Collections.sort(uu, new SortBy_Name());
			break;
		case 2: Collections.sort(uu, new SortBy_Email());
			break;
		case 3:Collections.sort(uu, new SortBy_Address());
			break;
		default : break;
		}
		
		
		System.out.println(uu.size()+"  users found");
		
		for(FacebookUser u:uu) {
			System.out.println("****************************************");
			System.out.println("Name is : "+u.getName());
			System.out.println("Password is : "+u.getPassword());
			System.out.println("Email is : "+u.getEmail());
			System.out.println("Address is : "+u.getAddress());
			System.out.println("****************************************");
		
	}
	}

	@Override
	public void userdetailwithhistory() {
 Map<String, List<FacebookUser>> uu=fs.userdetailwithhistoryservice();
		
		List<FacebookUser>  ll=uu.get("studentlist");
		
		for(FacebookUser u:ll) {
			System.out.println("****************************************");
			System.out.println("Name is : "+u.getName());
			System.out.println("Password is : "+u.getPassword());
			System.out.println("Email is : "+u.getEmail());
			System.out.println("Address is : "+u.getAddress());
			System.out.println("****************************************");
		}
		
		
      List<FacebookUser>  ll1=uu.get("studentlist2");
		
		for(FacebookUser u:ll1) {
			System.out.println("-----------------------------------------");
			System.out.println("Name is : "+u.getName());
			System.out.println("Password is : "+u.getPassword());
			System.out.println("Email is : "+u.getEmail());
			System.out.println("Address is : "+u.getAddress());
			System.out.println("-----------------------------------------");
		}

		
	}
		
}


	