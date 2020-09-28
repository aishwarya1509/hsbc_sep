package com.webinsta.utility;

import com.webinsta.service.ServiceInterface;
import com.webinsta.service.Servicelayer;

public class ServiceFactory {
	
private ServiceFactory() {
		
	}
	
	public static ServiceInterface createObject(String nn) {
		ServiceInterface is=null;
		if(nn.equals("adminservice")) {
			is=new Servicelayer();
		}
		return is;
	}

}
