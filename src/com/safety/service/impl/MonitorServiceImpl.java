package com.safety.service.impl;

import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.management.monitor.Monitor;

import org.springframework.stereotype.Service;

import com.safety.dao.IBaseDAO;
import com.safety.entity.MonitoringItem;
import com.safety.entity.User;
import com.safety.service.IMonitorService;

@Service("monitorService")
public class MonitorServiceImpl implements IMonitorService {
	@Resource
	private IBaseDAO<MonitoringItem> baseDao;

	@Override
	public void saveItem(MonitoringItem item) {
		// TODO Auto-generated method stub
		baseDao.save(item);
	}

	@Override
	public void updateItem(MonitoringItem item) {
		// TODO Auto-generated method stub
		baseDao.update(item);
	}

	@Override
	public MonitoringItem findItemById(int id) {
		// TODO Auto-generated method stub
		return baseDao.get(MonitoringItem.class, id);
	}

	@Override
	public void deleteItem(MonitoringItem item) {
		// TODO Auto-generated method stub
		baseDao.delete(item);
	}

	@Override
	public List<MonitoringItem> findAllList(User user) {
		// TODO Auto-generated method stub
		return baseDao.find("from MonitoringItem i,User u where u.id=i.uid order by i.createTime");
	}

	@Override
	public List<MonitoringItem> findItemsByTaskType(int tasktype) {
		// TODO Auto-generated method stub
		return baseDao.find("from MonitoringItem i where i.taskType = ?",
				new Object[] { tasktype });
	}

	@Override
	public boolean checkTarget(MonitoringItem item) {
		// TODO Auto-generated method stub
		if (item.getTaskType().equals(MonitoringItem.TaskType.HTTP)) {
			if (!item.getTarget()
					.matches(
							"(http|ftp|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&amp;:/~\\+#]*[\\w\\-\\@?^=%&amp;/~\\+#])?")) {
				return false;
			}
			return true;
		}
		String dnsRegex = "[0-9a-zA-Z][-0-9a-zA-Z]\\.([0-9a-zA-Z][-0-9a-zA-Z])+\\.?";
		String ipRegex="((25[0-5])|(2[0-4]\\d)|(1\\d\\d)|([1-9]\\d)|\\d)(\\.((25[0-5])|(2[0-4]\\d)|(1\\d\\d)|([1-9]\\d)|\\d)){3}";
		String str =item.getTarget();
		if(str.matches(ipRegex)||str.matches(dnsRegex))
			return true;
		return false;
	}

}
