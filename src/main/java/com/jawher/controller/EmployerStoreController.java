package com.jawher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jawher.entity.Employer;
import com.jawher.services.IEmployerStoreService;

@Controller
@RequestMapping("Employerservice")
public class EmployerStoreController {
	
	@Autowired
	private IEmployerStoreService service;
	
	@GetMapping("get")
	public ResponseEntity<List<Employer>> getEmployers(){
		
		List<Employer> Employers = service.getEmployers();
		return new ResponseEntity<List<Employer>>(Employers, HttpStatus.OK);
		
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<Employer> getEmployer(@PathVariable("id") Integer id){
		Employer Employer = service.getEmployer(id);
		return new ResponseEntity<Employer>(Employer, HttpStatus.OK);
	}
	
	@PostMapping("add")
	public ResponseEntity<Employer> createEmployer(@RequestBody Employer Employer){
		Employer b = service.createEmployer(Employer);
		return new ResponseEntity<Employer>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Employer> updateEmployer(@PathVariable("id") int id, @RequestBody Employer Employer){
		
		Employer b = service.updateEmployer(id, Employer);
		return new ResponseEntity<Employer>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteEmployer(@PathVariable("id") int id){
		boolean isDeleted = service.deleteEmployer(id);
		if(isDeleted){
			String responseContent = "Employer has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Employer from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
