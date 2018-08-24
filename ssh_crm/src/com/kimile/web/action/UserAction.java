package com.kimile.web.action;

import javax.persistence.metamodel.SetAttribute;

import com.kimile.domain.User;
import com.kimile.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private UserService userService;
	private User user=new User();

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	public String login() throws Exception {
		//1.调用service执行登录逻辑
		User u = userService.getUserByCodePassword(user);
		//2.将返回的User对象放入session中
		ActionContext.getContext().getSession().put("user", u);
		//重定向到项目首页
		return "toHome";
	}


	@Override
	public User getModel() {
		
		return user;
	}



}
