package com.skeletons.service;

import com.skeletons.dao.TelegramDao;
import com.skeletons.dao.TelegramDaoInterface;
import com.skeletons.telegram.entity.TelegramUser;

public class TelegramService implements TelegramServiceInterface{
	
 private TelegramDaoInterface td;
	
	public TelegramService(){
		td=new TelegramDao();
	}

	@Override
	public int createProfileService(TelegramUser tu) throws Exception{
		 int i=td.createProfileDAO(tu);
			return i;
		
	}

	@Override
	public void editProfileService() {
		td.deleteData();
		System.out.println("Edit Profile Service");
	}

	@Override
	public void deleteProfileService() {
	}

	@Override
	public void viewProfileService() {
	
	}

}
