package com.skeletons.service;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.skeletons.dao.FacebookDaoInterface;
import com.skeletons.facebook.entity.FacebookUser;
import com.skeletons.facebook.utility.DaoFactory;
import com.skeletons.facebook.utility.FacebookException;

public class FacebookService implements FacebookServiceInterface {
	
private FacebookDaoInterface fdao;
	
	public FacebookService(){
		//fdao=new FacebookDao();
		fdao=DaoFactory.createObject("admindao");
	}

	@Override
	public int createProfileService(FacebookUser fu) throws IOException 
	{
        int i=fdao.createProfileDAO(fu);
		return i;
		
	}

	@Override
	public int editProfileService(FacebookUser fu,int k) 
	{
		int i=0;
		i=fdao.editProfileDao(fu,k);
		return i;
		
	}

	@Override
	public int deleteProfileService(FacebookUser fu) 
	{
		int i=0;
		i = fdao.deleteProfileDao(fu);
		return i;
		
	}

	
	@Override
	public List<FacebookUser> searchProfileService(FacebookUser fu) throws FacebookException
	{  List<FacebookUser> ll=null;
	    try {
	    	ll = fdao.searchProfileDao(fu);
	    }
		catch(FacebookException e)
		{
			throw new FacebookException("");
		}
		
		 return ll;
	}
	
    @Override
	public List<FacebookUser> viewallprofileService()
    {
		return fdao.viewallProfileDao();

	}

	@Override
	public FacebookUser viewProfileService(FacebookUser fu) 
	{
		FacebookUser fu1 = fdao.viewProfileDao(fu);
		return fu1;
		
	}

	@Override
	public Map<String, List<FacebookUser>> userdetailwithhistoryservice() {
		return fdao.userdetailwithhistorydao();
	}

}
