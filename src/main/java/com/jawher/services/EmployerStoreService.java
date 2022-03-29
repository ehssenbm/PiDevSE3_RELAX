package com.jawher.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jawher.dao.IEmployerStoreDAO;
import com.jawher.entity.Employer;

@Service
public class EmployerStoreService implements IEmployerStoreService {
	
	@Autowired
	private IEmployerStoreDAO dao;

	@Override
	public List<Employer> getEmployers() {
		return dao.getEmployers();
	}

	@Override
	public Employer createEmployer(Employer Employer) {
		return dao.createEmployer(Employer);
	}

	@Override
	public Employer updateEmployer(int EmployerId, Employer Employer) {
		return dao.updateEmployer(EmployerId, Employer);
	}

	@Override
	public Employer getEmployer(int EmployerId) {
		return dao.getEmployer(EmployerId);
	}

	@Override
	public boolean deleteEmployer(int EmployerId) {
		return dao.deleteEmployer(EmployerId);
	}

}
