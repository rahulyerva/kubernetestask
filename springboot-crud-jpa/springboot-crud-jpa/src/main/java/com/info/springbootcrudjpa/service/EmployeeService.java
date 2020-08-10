package com.info.springbootcrudjpa.service;

import java.util.List;

import com.info.springbootcrudjpa.model.EmployeeModel;

public interface EmployeeService {


	public List<EmployeeModel> findAll();
	
	public EmployeeModel findById(int id);
	
	public void save(EmployeeModel employee);
	
	public void deleteById(int id);
	
}
