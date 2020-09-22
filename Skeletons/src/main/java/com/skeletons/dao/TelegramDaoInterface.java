package com.skeletons.dao;

import com.skeletons.telegram.entity.TelegramUser;

public interface TelegramDaoInterface {
	int createProfileDAO(TelegramUser tu) throws Exception;
	void deleteData();
}
