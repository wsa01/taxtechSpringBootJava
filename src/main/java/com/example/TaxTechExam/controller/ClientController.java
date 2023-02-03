package com.example.TaxTechExam.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaxTechExam.enumeration.StatusEnum;
import com.example.TaxTechExam.model.ClientModel;
import com.example.TaxTechExam.request.ClientReq;
import com.example.TaxTechExam.response.GeneralResponse;
import com.example.TaxTechExam.service.ClientService;

@RestController
@RequestMapping("/TaxTech")
@CrossOrigin(origins = "*")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping("/listclients")
	ResponseEntity<?> listClient(){
		List<ClientModel> result = clientService.list();
		return ResponseEntity.ok(new GeneralResponse<>(StatusEnum.OK.getStatus(),result));
	}
	
	@PostMapping("/createclient")
	ResponseEntity<?> createClient(@Valid @RequestBody ClientReq clientReq){
			clientService.createClient(clientReq);
			
		return new ResponseEntity<>(StatusEnum.OK.getStatus(), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteclient/{dni}")
	ResponseEntity<?> deleteClient(@PathVariable String dni){
			clientService.deleteClient(dni);
		return new ResponseEntity<>(StatusEnum.OK.getStatus(),HttpStatus.OK);
	}
	
	@PutMapping("/updateclient")
	ResponseEntity<?> updateClient(@Valid @RequestBody ClientReq clientReq){
			System.out.println(clientReq.toString());
			clientService.updateClient(clientReq);
		return new ResponseEntity<>(StatusEnum.OK.getStatus(), HttpStatus.OK);
	}
	
}
