package com.kimile.service;

import com.kimile.domain.User;

public interface UserService {
	//��¼����
	User getUserByCodePassword(User u);
	//����
	void saveUser(User u);

}
