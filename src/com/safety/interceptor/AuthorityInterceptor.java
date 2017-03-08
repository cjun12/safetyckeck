package com.safety.interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.safety.entity.User;

public class AuthorityInterceptor extends MethodFilterInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> session = invocation.getInvocationContext().getSession();
		User user = (User)session.get("user");
		if(user != null){
			return invocation.invoke();
		}
		HttpServletResponse response = (HttpServletResponse) ServletActionContext.getResponse();
		Cookie deleteToken = new Cookie("token","");
		deleteToken.setMaxAge(0);
		deleteToken.setPath("/");
		response.addCookie(deleteToken);
		return Action.LOGIN;
	}

	

}
