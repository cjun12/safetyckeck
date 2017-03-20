package com.safety.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.safety.dao.IBaseDAO;
import com.safety.entity.DnsDetail;
import com.safety.entity.SnmpDetail;
import com.safety.service.IDetailService;

@Service("snmpDetail")
public class SnmpDetailServiceImpl implements IDetailService<SnmpDetail>{
	@Resource
	private IBaseDAO<SnmpDetail> baseDAO;


	@Override
	public SnmpDetail getDetailById(int id) {
		// TODO Auto-generated method stub
		return baseDAO.get(SnmpDetail.class, id);
	}

	@Override
	public List<SnmpDetail> getAllDetail() {
		// TODO Auto-generated method stub
		return baseDAO.find("from SnmpDetail h order by create_time");
	}

	@Override
	public void save(SnmpDetail detail) {
		// TODO Auto-generated method stub
		baseDAO.save(detail);
	}

	@Override
	public void update(SnmpDetail detail) {
		// TODO Auto-generated method stub
		baseDAO.update(detail);
	}

	@Override
	public void delete(SnmpDetail detail) {
		// TODO Auto-generated method stub
		baseDAO.delete(detail);
	}
	

}
