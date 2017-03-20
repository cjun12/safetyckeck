package com.safety.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.safety.entity.MonitoringItem;
import com.safety.entity.User;
import com.safety.service.IMonitorService;


public class UserCenterAction extends ActionSupport {
	private List<MonitoringItem> items;
	
	public List<MonitoringItem> getItems() {
		return items;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private IMonitorService monitorService;
	public String index() {
		return SUCCESS;
	}
	public String httpMonitor(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		User user = (User)session.get("user");
		items = monitorService.findItemsByTaskType(MonitoringItem.HTTP, user.getId());
		
		return SUCCESS;
	}
	public String dnsMonitor(){
		return SUCCESS;
	}
	public String snmpMonitor(){
		return SUCCESS;
	}
	public String pingMonitor(){
		return SUCCESS;
	}
}
