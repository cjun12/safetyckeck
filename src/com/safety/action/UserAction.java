package com.safety.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.safety.entity.User;
import com.safety.service.IUserService;
import com.safety.service.impl.UserServiceImpl;
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
		User user = userService.findUserByNameAndPassword(u.getUsername(), u.getPassword());
		if(user != null){
			ActionContext.getContext().getSession().put("user", user);
			return SUCCESS;
		}
		else{
			return ERROR;
		}
	}
	
	public String regist(){
		User user = userService.findByUserName(u.getUsername());
		if(user != null)
			return ERROR;
		u.setPassword(Toolkit.getMD5(u.getPassword()));
		userService.saveUser(u);
		return SUCCESS;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	
	
}
