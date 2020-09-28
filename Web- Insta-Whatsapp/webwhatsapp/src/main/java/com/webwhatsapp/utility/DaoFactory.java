package com.webwhatsapp.utility;

import com.webwhatsapp.dao.DaoInterface;
import com.webwhatsapp.dao.DaoLayer;

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
