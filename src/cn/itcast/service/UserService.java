package cn.itcast.service;

import cn.itcast.domain.User;

public interface UserService {
	//
	User	getUserByCodePassword(User u);
	//±£´æ×¢²áÓÃ»§
	void saveUser(User u);
}
