package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao extends BaseDao<User> {
	
	//根据注册的登陆名获得用户对象
	User getByUserCode(String usercode);
}
