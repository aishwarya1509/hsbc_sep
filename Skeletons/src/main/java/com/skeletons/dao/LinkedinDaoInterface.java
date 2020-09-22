package com.skeletons.dao;

import com.skeletons.linkedin.entity.LinkedinUser;

public interface LinkedinDaoInterface {
	int createProfileDAO(LinkedinUser fu)throws Exception;
	void deleteData();

}
