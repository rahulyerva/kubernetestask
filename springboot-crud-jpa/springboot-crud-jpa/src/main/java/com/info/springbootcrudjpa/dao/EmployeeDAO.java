package com.info.springbootcrudjpa.dao;

import java.util.List;

import com.info.springbootcrudjpa.model.EmployeeModel;

public interface EmployeeDAO {

	public List<EmployeeModel> findAll();
	
	public EmployeeModel findById(int id);
	
	public void save(EmployeeModel employee);
	
	public void deleteById(int id);
}
