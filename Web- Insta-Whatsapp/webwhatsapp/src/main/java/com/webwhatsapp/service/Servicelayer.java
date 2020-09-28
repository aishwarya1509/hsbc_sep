package com.webwhatsapp.service;

import java.io.IOException;
import java.util.List;

import com.webwhatsapp.dao.DaoInterface;
import com.webwhatsapp.entity.WhatsappUser;
import com.webwhatsapp.utility.DaoFactory;

public class Servicelayer implements ServiceInterface {

private DaoInterface fdao;
	
	public Servicelayer(){
		
		fdao=DaoFactory.createObject("admindao");
	}

	@Override
	public int createProfileService(WhatsappUser fu) throws IOException 
	{
        int i=fdao.createProfileDAO(fu);
		return i;
		
	}

	@Override
	public boolean loginProfile(WhatsappUser fe) {
		// TODO Auto-generated method stub
		return fdao.loginProfile(fe);
	}

	@Override
	public List<WhatsappUser> friendProfile(WhatsappUser fe) {
		// TODO Auto-generated method stub
		return fdao.friendlistdao(fe);
	}

	

}
