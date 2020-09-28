package com.webinsta.service;

import java.io.IOException;
import java.util.List;

import com.webinsta.entity.InstaUser;


public interface ServiceInterface {
	
	int createProfileService(InstaUser fu) throws IOException ;

	boolean loginProfile(InstaUser fe);

	List<InstaUser> friendProfile(InstaUser fe);

	
	
}
