package com.webinsta.service;

import java.io.IOException;
import java.util.List;

import com.webinsta.dao.DaoInterface;
import com.webinsta.entity.InstaUser;
import com.webinsta.utility.DaoFactory;

public class Servicelayer implements ServiceInterface {

private DaoInterface fdao;
	
	public Servicelayer(){
		
		fdao=DaoFactory.createObject("admindao");
	}

	@Override
	public int createProfileService(InstaUser fu) throws IOException 
	{
        int i=fdao.createProfileDAO(fu);
		return i;
		
	}

	@Override
	public boolean loginProfile(InstaUser fe) {
		// TODO Auto-generated method stub
		return fdao.loginProfile(fe);
	}

	@Override
	public List<InstaUser> friendProfile(InstaUser fe) {
		// TODO Auto-generated method stub
		return fdao.friendlistdao(fe);
	}

	

}
