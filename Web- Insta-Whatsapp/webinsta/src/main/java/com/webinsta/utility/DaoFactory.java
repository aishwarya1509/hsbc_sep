package com.webinsta.utility;

import com.webinsta.dao.DaoInterface;
import com.webinsta.dao.DaoLayer;

public class DaoFactory {

private DaoFactory() {
		
	}
	
	public static DaoInterface createObject(String nn) {
		DaoInterface is=null;
		if(nn.equals("admindao")) {
			is=new DaoLayer();
		}
		return is;
	}

	
}
