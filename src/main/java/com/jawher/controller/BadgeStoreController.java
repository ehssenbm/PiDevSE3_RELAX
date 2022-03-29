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

import com.jawher.entity.Badge;
import com.jawher.services.IBadgeStoreService;

@Controller
@RequestMapping("Badgeservice")
public class BadgeStoreController {
	
	@Autowired
	private IBadgeStoreService service;
	
	@GetMapping("get")
	public ResponseEntity<List<Badge>> getAdministrateurs(){
		
		List<Badge> Administrateurs = service.getAdministrateurs();
		return new ResponseEntity<List<Badge>>(Administrateurs, HttpStatus.OK);
		
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<Badge> getAdministrateur(@PathVariable("id") Integer id){
		Badge Administrateur = service.getAdministrateur(id);
		return new ResponseEntity<Badge>(Administrateur, HttpStatus.OK);
	}
	
	@PostMapping("add")
	public ResponseEntity<Badge> createAdministrateur(@RequestBody Badge Administrateur){
		Badge b = service.createAdministrateur(Administrateur);
		return new ResponseEntity<Badge>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Badge> updateAdministrateur(@PathVariable("id") int id, @RequestBody Badge Administrateur){
		
		Badge b = service.updateAdministrateur(id, Administrateur);
		return new ResponseEntity<Badge>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteAdministrateur(@PathVariable("id") int id){
		boolean isDeleted = service.deleteAdministrateur(id);
		if(isDeleted){
			String responseContent = "Badge has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Badge from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
