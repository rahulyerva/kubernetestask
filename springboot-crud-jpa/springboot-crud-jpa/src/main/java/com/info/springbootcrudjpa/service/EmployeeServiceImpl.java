package com.info.springbootcrudjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info.springbootcrudjpa.dao.EmployeeDAO;
import com.info.springbootcrudjpa.model.EmployeeModel;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeServiceImpl(EmployeeDAO eDAO) {
		employeeDAO = eDAO;
	}

	@Override
	@Transactional
	public List<EmployeeModel> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public EmployeeModel findById(int id) {
		return employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(EmployeeModel employee) {
		employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		employeeDAO.deleteById(id);
	}

}
