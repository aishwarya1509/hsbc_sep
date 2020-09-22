package com.skeletons.facebook.utility;

import com.skeletons.service.FacebookService;
import com.skeletons.service.FacebookServiceInterface;

public class ServiceFactory {
	
private ServiceFactory() {
		
	}
	
	public static FacebookServiceInterface createObject(String nn) {
		FacebookServiceInterface is=null;
		if(nn.equals("adminservice")) {
			is=new FacebookService();
		}
		return is;
	}

}
