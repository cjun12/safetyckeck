package com.safety.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.safety.dao.IBaseDAO;
import com.safety.entity.HttpDetail;
import com.safety.entity.PingDetail;
import com.safety.service.IDetailService;

@Service("pingDetailService")
public class PingDetailServiceImpl implements IDetailService<PingDetail> {
	
	@Resource
	private IBaseDAO<PingDetail> baseDAO;


	@Override
	public PingDetail getDetailById(int id) {
		// TODO Auto-generated method stub
		return baseDAO.get(PingDetail.class, id);
	}

	@Override
	public List<PingDetail> getAllDetail() {
		// TODO Auto-generated method stub
		return baseDAO.find("from PingDetail h order by create_time");
	}

	@Override
	public void save(PingDetail detail) {
		// TODO Auto-generated method stub
		baseDAO.save(detail);
	}

	@Override
	public void update(PingDetail detail) {
		// TODO Auto-generated method stub
		baseDAO.update(detail);
	}

	@Override
	public void delete(PingDetail detail) {
		// TODO Auto-generated method stub
		baseDAO.delete(detail);
	}
	

}
