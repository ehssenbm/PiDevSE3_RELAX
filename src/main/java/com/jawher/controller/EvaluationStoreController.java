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

import com.jawher.entity.Choix;
import com.jawher.entity.Evaluation;
import com.jawher.services.IChoixStoreService;
import com.jawher.services.IEvaluationStoreService;

@Controller
@RequestMapping("Evaluationservice")
public class EvaluationStoreController {
	
	@Autowired
	private IEvaluationStoreService service;
	private IChoixStoreService serviceChoix;
	@GetMapping("get")
	public ResponseEntity<List<Evaluation>> getEvaluations(){
		
		List<Evaluation> Evaluations = service.getEvaluations();
		return new ResponseEntity<List<Evaluation>>(Evaluations, HttpStatus.OK);
		
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<Evaluation> getEvaluation(@PathVariable("id") Integer id){
		
	 
		Evaluation Evaluation = service.getEvaluation(id);
		 //Choix  Choix = serviceChoix.getChoix(id);
		
		return new ResponseEntity<Evaluation>(Evaluation, HttpStatus.OK);
		// ResponseEntity<Choix>(Choix, HttpStatus.OK);
		 
	}
	
	@PostMapping("add")
	public ResponseEntity<Evaluation> createEvaluation(@RequestBody Evaluation Evaluation){
		Evaluation b = service.createEvaluation(Evaluation);
		return new ResponseEntity<Evaluation>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Evaluation> updateEvaluation(@PathVariable("id") int id, @RequestBody Evaluation Evaluation){
		
		Evaluation b = service.updateEvaluation(id, Evaluation);
		return new ResponseEntity<Evaluation>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteEvaluation(@PathVariable("id") int id){
		boolean isDeleted = service.deleteEvaluation(id);
		if(isDeleted){
			String responseContent = "Evaluation has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting Evaluation from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
