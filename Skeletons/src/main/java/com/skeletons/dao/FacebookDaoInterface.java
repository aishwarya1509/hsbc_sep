package com.skeletons.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.skeletons.facebook.entity.FacebookUser;
import com.skeletons.facebook.utility.FacebookException;

public interface FacebookDaoInterface {
	int createProfileDAO(FacebookUser fu) throws IOException ;
	FacebookUser viewProfileDao(FacebookUser fu) ;
	int editProfileDao(FacebookUser fu,int k) ;
	int deleteProfileDao(FacebookUser fu)  ;
	public List<FacebookUser> searchProfileDao(FacebookUser fu) throws FacebookException ;
	public List<FacebookUser> viewallProfileDao();
	Map<String, List<FacebookUser>> userdetailwithhistorydao();
	
}
