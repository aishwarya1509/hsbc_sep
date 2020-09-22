package com.skeletons.service;

import com.skeletons.dao.LinkedinDao;
import com.skeletons.dao.LinkedinDaoInterface;
import com.skeletons.linkedin.entity.LinkedinUser;

public class LinkedinService implements LinkedinServiceInterface {
private LinkedinDaoInterface ldao;
	
	public LinkedinService(){
		ldao=new LinkedinDao();
	}

	@Override
	public int createProfileService(LinkedinUser lu) throws Exception
	{
		  int i=ldao.createProfileDAO(lu);
			return i;
	}

	@Override
	public void editProfileService() {
		ldao.deleteData();
		System.out.println("Edit Profile Service");
	}

	@Override
	public void deleteProfileService() {
		
	}

	@Override
	public void viewProfileService() {
	
		
	}

	@Override
	public void createProfileService() {
		// TODO Auto-generated method stub
		
	}

	

}
