package com.info.springbootcrudjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.info.springbootcrudjpa.model.EmployeeModel;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	// define field for entity manager

	@PersistenceContext
	private EntityManager entityManager;
	// set up constructor injection 
	
	@Autowired
	public EmployeeDAOImpl(EntityManager theEntityManager) {
       entityManager=theEntityManager;
	}
	
	@Override
	public List<EmployeeModel> findAll() {
       
	  
	  Query query= entityManager.createQuery("from EmployeeModel");
	  
	  List<EmployeeModel> employees= query.getResultList();
	  return employees;
	  
	}

	@Override
	public EmployeeModel findById(int id) {

		
		EmployeeModel employee= entityManager.find(EmployeeModel.class, id);
		
		return employee;
	}

	@Override
	public void save(EmployeeModel employee) {


		EmployeeModel theEmployee= entityManager.merge(employee);
		
		employee.setId(theEmployee.getId());
	}

	@Override
	public void deleteById(int id) {
  

		  Query query= entityManager.createQuery("delete from EmployeeModel where id=: employeeId");

		 query.setParameter("employeeId", id);
		 
		 query.executeUpdate();
		
	}
	
	

	
}
