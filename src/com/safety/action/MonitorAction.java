package com.safety.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.safety.entity.MonitoringItem;
import com.safety.service.IMonitorService;

public class MonitorAction extends ActionSupport {

	private IMonitorService monitorService;
	private MonitoringItem item;

	public String addItem() {
		if (!monitorService.checkTarget(item))
			return ERROR;
		monitorService.saveItem(item);
		return SUCCESS;
	}

	public String deleteItem() {
		MonitoringItem i = monitorService.findItemById(item.getId());
		monitorService.deleteItem(i);
		return SUCCESS;
	}

	public String updateItem() {
		monitorService.updateItem(item);
		return SUCCESS;
	}

	public String listTTItem() {
		List<MonitoringItem> items = monitorService.findItemsByTaskType(item
				.getTaskType().ordinal());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("items", items);
		return SUCCESS;
	}

	public String listAllItem() {
		List<MonitoringItem> items = monitorService.findAllList();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("items", items);
		return SUCCESS;
	}
}
