package com.kimile.service;

import com.kimile.domain.User;

public interface UserService {
	//µÇÂ¼·½·¨
	User getUserByCodePassword(User u);
	//±£´æ
	void saveUser(User u);

}
