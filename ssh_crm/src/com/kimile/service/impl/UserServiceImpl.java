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
		// ���ݵ�¼����ѯ��¼�û�
		User existU=ud.getByUserCode(u.getUser_code());
	    //�ж��û��Ƿ���ڣ������ھ��׳��쳣,��ʾ�û���������
		if(existU==null) {
			throw new RuntimeException("�û���������!");
		}
		//�ж��û������Ƿ���ȷ ������ʾ�������
		if(!existU.getUser_password().equals(u.getUser_password())) {
			throw new RuntimeException("�������!");
		}
		return existU;
	}

	@Override
	public void saveUser(User u) {
		ud.save(u);
		
	}

	

}
