package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao extends BaseDao<User> {
	
	//����ע��ĵ�½������û�����
	User getByUserCode(String usercode);
}
