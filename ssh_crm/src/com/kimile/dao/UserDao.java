package com.kimile.dao;

import com.kimile.domain.User;

public interface UserDao {


	//���ݵ�½���Ʋ�ѯuser����
	User getByUserCode(String usercode);
	//�����û�
	void save(User u);
}
