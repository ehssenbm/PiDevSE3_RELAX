package com.jawher.services;

import java.util.List;

import com.jawher.entity.Employer;

public interface IEmployerStoreService {
	
	List<Employer> getEmployers();
	Employer createEmployer(Employer Employer);
	Employer updateEmployer(int EmployerId, Employer Employer);
	Employer getEmployer(int EmployerId);
	boolean deleteEmployer(int EmployerId);

}
