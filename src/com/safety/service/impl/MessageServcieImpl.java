package com.safety.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.safety.dao.IBaseDAO;
import com.safety.entity.Message;
import com.safety.entity.User;
import com.safety.service.IMessageService;

public class MessageServcieImpl implements IMessageService {
	@Resource
	private IBaseDAO<Message> baseDao;

	public IBaseDAO<Message> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDAO<Message> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void saveMessage(Message message) {
		// TODO Auto-generated method stub
		baseDao.save(message);
	}

	@Override
	public void updateMessage(Message message) {
		// TODO Auto-generated method stub
		baseDao.update(message);
	}

	@Override
	public void deleteMessage(Message message) {
		// TODO Auto-generated method stub
		baseDao.delete(message);
	}

	@Override
	public List<Message> findAllList(User user) {
		// TODO Auto-generated method stub
		return baseDao.find("select Message m where uid= ?" ,new Object[]{user.getId()});
	}

}
