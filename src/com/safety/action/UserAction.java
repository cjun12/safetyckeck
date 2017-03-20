package com.safety.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.safety.entity.User;
import com.safety.service.IUserService;
import com.safety.util.Toolkit;

@Controller
public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private IUserService userService;

	private User u;

	public String login() {
		User userCheck = (User) ActionContext.getContext().getSession()
				.get("user");
		u.setPassword(Toolkit.getMD5(u.getPassword()));
		if (userCheck != null && userCheck.getPassword() == u.getPassword()
				&& u.getUsername() == userCheck.getUsername())
			return SUCCESS;
		HttpServletResponse response = ServletActionContext.getResponse();
		User user = userService.findUserByNameAndPassword(u.getUsername(),
				u.getPassword());
		if (user != null) {
			String tokenStr = user.getPassword() + new Date().getTime();
			String token = Toolkit.getMD5(tokenStr);
			user.setToken(token);
			userService.updateUser(user);
			Cookie cookie = new Cookie("token", token);
			cookie.setMaxAge(7 * 24 * 60 * 60);//Cookie保存7天
			cookie.setPath("/");
			response.addCookie(cookie);
			ActionContext.getContext().getSession().put("user", user);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String regist() {
		User user = userService.findByUserName(u.getUsername());
		if (user != null)
			return ERROR;
		u.setPassword(Toolkit.getMD5(u.getPassword()));
		userService.saveUser(u);
		return SUCCESS;
	}
	public String logout(){
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

}
