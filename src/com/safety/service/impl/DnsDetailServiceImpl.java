package com.safety.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.safety.dao.IBaseDAO;
import com.safety.entity.DnsDetail;
import com.safety.service.IDetailService;

@Service("dnsDetail")
public class DnsDetailServiceImpl implements IDetailService<DnsDetail>{
	@Resource
	private IBaseDAO<DnsDetail> baseDAO;


	@Override
	public DnsDetail getDetailById(int id) {
		// TODO Auto-generated method stub
		return baseDAO.get(DnsDetail.class, id);
	}

	@Override
	public List<DnsDetail> getAllDetail() {
		// TODO Auto-generated method stub
		return baseDAO.find("from DnsDetail h order by create_time");
	}

	@Override
	public void save(DnsDetail detail) {
		// TODO Auto-generated method stub
		baseDAO.save(detail);
	}

	@Override
	public void update(DnsDetail detail) {
		// TODO Auto-generated method stub
		baseDAO.update(detail);
	}

	@Override
	public void delete(DnsDetail detail) {
		// TODO Auto-generated method stub
		baseDAO.delete(detail);
	}
	

}
