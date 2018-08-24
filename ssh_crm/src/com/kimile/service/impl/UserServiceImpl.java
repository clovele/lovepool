package com.kimile.service.impl;

import org.bouncycastle.crypto.RuntimeCryptoException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kimile.dao.UserDao;
import com.kimile.domain.User;
import com.kimile.service.UserService;
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class UserServiceImpl implements UserService{
private UserDao ud;
	public void setUd(UserDao ud) {
	this.ud = ud;
}

	@Override
	public User getUserByCodePassword(User u) {
		// 根据登录名查询登录用户
		User existU=ud.getByUserCode(u.getUser_code());
	    //判断用户是否存在，不存在就抛出异常,提示用户名不存在
		if(existU==null) {
			throw new RuntimeException("用户名不存在!");
		}
		//判断用户密码是否正确 否则提示密码错误
		if(!existU.getUser_password().equals(u.getUser_password())) {
			throw new RuntimeException("密码错误!");
		}
		return existU;
	}

	@Override
	public void saveUser(User u) {
		ud.save(u);
		
	}

	

}
