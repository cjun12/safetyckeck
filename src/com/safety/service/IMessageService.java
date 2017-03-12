package com.safety.service;

import java.util.List;

import com.safety.entity.Message;
import com.safety.entity.User;

public interface IMessageService {

	public void saveMessage(Message message);

	public void updateMessage(Message message);

	public void deleteMessage(Message message);

	public List<Message> findAllList(User user);
}
