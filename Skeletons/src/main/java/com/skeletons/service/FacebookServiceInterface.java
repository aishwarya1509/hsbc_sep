package com.skeletons.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.skeletons.facebook.entity.FacebookUser;
import com.skeletons.facebook.utility.FacebookException;

public interface FacebookServiceInterface {
	int createProfileService(FacebookUser fu) throws IOException ;
	public int editProfileService(FacebookUser fu,int k) ;
	int deleteProfileService(FacebookUser fu) ;
	
	public List<FacebookUser> searchProfileService(FacebookUser fu) throws FacebookException ;
	List<FacebookUser> viewallprofileService();
	FacebookUser viewProfileService(FacebookUser fu) ;
	Map<String, List<FacebookUser>> userdetailwithhistoryservice();

}
