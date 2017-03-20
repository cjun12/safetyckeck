package com.safety.service;

import java.util.List;

public interface IDetailService<T> {
	public T getDetailById(int id);
	public List<T> getAllDetail();
	public void save(T detail);
	public void update(T detail);
	public void delete(T detail);
}
