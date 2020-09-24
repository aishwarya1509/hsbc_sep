package com.Exam.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.Exam.business.ExamBusinessInterface;
import com.Exam.utility.ControllerFactory;


public class ExamView {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ExamBusinessInterface ei;
		ei=ControllerFactory.createObject("adminservice");
		String cc="y";
		while(cc.equals("y")) {
		System.out.println("MAIN MENU");
		System.out.println("Press 1 to Enter Details of Food");
		System.out.println("Press 2 to Enter Details of Electronics");
		System.out.println("Press 3 to Enter Details of Apparel");
		System.out.println("Press 4 to Show top items in every Category");
		
		System.out.println("enter your choice");
		int i=Integer.parseInt(br.readLine());
	
		switch(i) {
		case 1:ei.insertinList(i);
			break;
		case 2:ei.insertinList(i);
		     break;
		case 3:ei.insertinList(i);
		     break;
		case 4:ei.Showlist();
		      break;
		
		default:System.out.println("wrong choice");
		}
		System.out.println("do you want to continue press y/n");
		cc=br.readLine();
		}
		
	}

}
