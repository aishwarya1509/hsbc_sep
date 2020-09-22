package com.skeletons.facebook.utility;

import com.skeletons.dao.FacebookDao;
import com.skeletons.dao.FacebookDaoInterface;

public class DaoFactory {

private DaoFactory() {
		
	}
	
	public static FacebookDaoInterface createObject(String nn) {
		FacebookDaoInterface is=null;
		if(nn.equals("admindao")) {
			is=new FacebookDao();
		}
		return is;
	}

	
}
