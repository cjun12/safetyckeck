package com.safety.service;

import java.util.List;

import com.safety.entity.MonitoringItem;
import com.safety.entity.User;

public interface IMonitorService {

	public void saveItem(MonitoringItem item);

	public void updateItem(MonitoringItem item);

	public MonitoringItem findItemById(int id);

	public void deleteItem(MonitoringItem item);

	public List<MonitoringItem> findAllList();

	public List<MonitoringItem> findUserAllList(User user);

	public List<MonitoringItem> findItemsByTaskType(int tasktype,int uid);

	public boolean checkTarget(MonitoringItem item);
}
