package com.webwhatsapp.utility;

import com.webwhatsapp.service.ServiceInterface;
import com.webwhatsapp.service.Servicelayer;

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
