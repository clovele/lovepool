package cn.itcast.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class UserServiceImpl implements UserService{

	private UserDao ud;

	@Override
	public User getUserByCodePassword(User u) {
		//1 ���ݵ�½���Ʋ�ѯ��½�û�
		User existU = ud.getByUserCode(u.getUser_code());
		//2 �ж��û��Ƿ����.������=>�׳��쳣,��ʾ�û���������
		if(existU==null){
			throw new RuntimeException("�û���������!");
		}
		if(!existU.getUser_password().equals(u.getUser_password())){
			throw new RuntimeException("�������!");
		}
		//4 

		return existU;
	}

	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveUser(User u) {
		//1 ����Dao����ע��ĵ�½������û�����
		User existU = ud.getByUserCode(u.getUser_code());
		if(existU!=null){
			//2 �����õ�user����,�û����Ѿ�����,�׳��쳣
			throw new RuntimeException("�û����Ѿ�����!");
		}
		//ʹ��MD5��������м���

		//3 ����Daoִ�б���
		ud.save(u);
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

}
