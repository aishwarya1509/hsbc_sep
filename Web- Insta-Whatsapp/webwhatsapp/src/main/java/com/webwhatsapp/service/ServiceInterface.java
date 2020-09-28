package com.webwhatsapp.service;

import java.io.IOException;
import java.util.List;

import com.webwhatsapp.entity.WhatsappUser;


public interface ServiceInterface {
	
	int createProfileService(WhatsappUser fu) throws IOException ;

	boolean loginProfile(WhatsappUser fe);

	List<WhatsappUser> friendProfile(WhatsappUser fe);

	
	
}
