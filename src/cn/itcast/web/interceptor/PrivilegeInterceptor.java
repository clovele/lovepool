package cn.itcast.web.interceptor;

import java.util.Map;

import org.aopalliance.intercept.Invocation;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.itcast.domain.User;

public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	//��У���¼��ע�᷽��
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//1.���Session
		Map<String, Object> session = ActionContext.getContext().getSession();
		//2.��õ�¼��ʶ
		User user = (User) session.get("user");
		//3.�жϱ�ʶ�Ƿ����
		//����=> ����
		if(user!=null) {
			return invocation.invoke();
		}
		//������=>�ض��򵽵�¼����
		else {
			return "toLogin";
		}
		
	
	}

}
