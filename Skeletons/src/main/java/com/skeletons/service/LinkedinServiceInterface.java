package com.skeletons.service;

import com.skeletons.linkedin.entity.LinkedinUser;

public interface LinkedinServiceInterface {
	int createProfileService(LinkedinUser lu)throws Exception;
	void editProfileService();
	void deleteProfileService();
	void viewProfileService();
	void createProfileService();
	

}
