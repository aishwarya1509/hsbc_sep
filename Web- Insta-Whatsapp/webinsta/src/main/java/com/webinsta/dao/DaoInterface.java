package com.webinsta.dao;

import java.io.IOException;
import java.util.List;

import com.webinsta.entity.InstaUser;


public interface DaoInterface {
	int createProfileDAO(InstaUser fu) throws IOException ;

	boolean loginProfile(InstaUser fe);

	List<InstaUser> friendlistdao(InstaUser fe);
	

}
