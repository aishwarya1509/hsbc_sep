package com.skeletons.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.skeletons.controller.FacebookController;
import com.skeletons.controller.FacebookControllerInterface;

public class FacebookView {
	public static void main(String[] args)throws Exception {
		char choice;  
		try (Scanner console1 = new Scanner(System.in)) {
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			do
			{
			System.out.println("MENU");
			System.out.println("press 1 to create profile");
			System.out.println("press 2 to edit profile");
			System.out.println("press 3 to delete profile");
			System.out.println("press 4 to view profile");
			System.out.println("press 5 to search profile");
			System.out.println("press 6 to viewAll profile");
			System.out.println("press 7 to View Lists");
			System.out.println("enter your choice ");
			
			int i=Integer.parseInt(br.readLine());

			FacebookControllerInterface fi=new FacebookController();

			switch(i) 
			{
			
			case 1: fi.createProfile();
				break;
			case 2: fi.editProfile();
				break;
			case 3:fi.deleteProfile();
				break;
			case 4:fi.viewProfile();
				break;
			case 5:fi.searchProfile();
				break;
			case 6:fi.viewAllProfile();
				break;
			case 7:fi.userdetailwithhistory();
			    break;
			default:System.out.println("wrong choice");
			  
			}
			System.out.print("To Continue enter Y for yes or N for no: ");
			choice = console1.next().charAt(0);
			
			}while((choice == 'y') || (choice == 'Y'));
		}
	}
}