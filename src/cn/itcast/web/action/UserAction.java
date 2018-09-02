package cn.itcast.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();

	private UserService userService ;


	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() throws Exception {
		//1 
		User u = userService.getUserByCodePassword(user);
		//2 
		ActionContext.getContext().getSession().put("user", u);
		//3 
		return "toHome";
	}
	public String regist() throws Exception {
		//1.����service����ע���û�
		try {
			userService.saveUser(user);
		} catch (Exception e) {
		
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		//�ض��򵽵�¼����
		return "toLogin";
	}

	@Override
	public User getModel() {
		return user;
	}



}
