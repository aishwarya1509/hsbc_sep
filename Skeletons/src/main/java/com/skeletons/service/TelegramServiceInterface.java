package com.skeletons.service;

import com.skeletons.telegram.entity.TelegramUser;

public interface TelegramServiceInterface {
	int createProfileService (TelegramUser tu)throws Exception;
	void editProfileService();
	void deleteProfileService();
	void viewProfileService();

}
