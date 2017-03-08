package com.safety.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.safety.dao.IBaseDAO;
import com.safety.dao.impl.BaseDAOImpl;
import com.safety.entity.User;
import com.safety.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IBaseDAO<User> baseDAO;
	
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		baseDAO.save(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		baseDAO.update(user);
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return baseDAO.get(User.class, id);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		baseDAO.delete(user);
	}

	@Override
	public List<User> findAllList() {
		// TODO Auto-generated method stub
		return baseDAO.find(" from User u order by u.id");
	}

	@Override
	public User findUserByNameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return baseDAO.get(
				" from User u where u.username = ? and u.password = ? ",
				new Object[] { username, password });
	}

	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		return baseDAO.get("from User u where u.username =?",
				new Object[] { username });
	}

}
