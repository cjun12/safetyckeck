package com.safety.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.safety.dao.IBaseDAO;
import com.safety.entity.HttpDetail;
import com.safety.service.IDetailService;

@Service("httpDetail")
public class HttpDetailServiceImpl implements IDetailService<HttpDetail> {

	@Resource
	private IBaseDAO<HttpDetail> baseDAO;

	@Override
	public HttpDetail getDetailById(int id) {
		// TODO Auto-generated method stub
		return baseDAO.get(HttpDetail.class, id);
	}

	@Override
	public List<HttpDetail> getAllDetail() {
		// TODO Auto-generated method stub
		return baseDAO.find("from HttpDetail h order by create_time");
	}

	@Override
	public void save(HttpDetail detail) {
		// TODO Auto-generated method stub
		baseDAO.save(detail);
	}

	@Override
	public void update(HttpDetail detail) {
		// TODO Auto-generated method stub
		baseDAO.update(detail);
	}

	@Override
	public void delete(HttpDetail detail) {
		// TODO Auto-generated method stub
		baseDAO.delete(detail);
	}

}
