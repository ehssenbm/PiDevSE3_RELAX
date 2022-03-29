package com.jawher.dao;

import java.util.List;

import com.jawher.entity.Employer;

public interface IEmployerStoreDAO {
	
	List<Employer> getEmployers();
	Employer getEmployer(int EmployerId);
	Employer createEmployer(Employer Employer);
	Employer updateEmployer(int EmployerId,Employer Employer);
	boolean deleteEmployer(int EmployerId);

}
