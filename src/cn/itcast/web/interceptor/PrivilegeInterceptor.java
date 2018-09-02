package cn.itcast.web.interceptor;

import java.util.Map;

import org.aopalliance.intercept.Invocation;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.itcast.domain.User;

public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	//不校验登录和注册方法
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//1.获得Session
		Map<String, Object> session = ActionContext.getContext().getSession();
		//2.获得登录标识
		User user = (User) session.get("user");
		//3.判断标识是否存在
		//存在=> 放行
		if(user!=null) {
			return invocation.invoke();
		}
		//不存在=>重定向到登录界面
		else {
			return "toLogin";
		}
		
	
	}

}
