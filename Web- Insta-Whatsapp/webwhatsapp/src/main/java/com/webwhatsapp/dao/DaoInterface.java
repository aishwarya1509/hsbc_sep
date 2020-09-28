package com.webwhatsapp.dao;

import java.io.IOException;
import java.util.List;

import com.webwhatsapp.entity.WhatsappUser;


public interface DaoInterface {
	int createProfileDAO(WhatsappUser fu) throws IOException ;

	boolean loginProfile(WhatsappUser fe);

	List<WhatsappUser> friendlistdao(WhatsappUser fe);
	

}
