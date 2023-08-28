package com.test.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.Empresa;
import com.test.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class ViewController {
	
	@Autowired
	private EmpresaService service;
	
	@GetMapping("/topthree")
	public ResponseEntity<List<Empresa>>getByTopThree(){
		return new ResponseEntity<>(service.getThreeLateEmpresa(),HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Object>saveEntity(@Valid @RequestBody Empresa empresa){
		return new ResponseEntity<>(service.saveEmpresa(empresa),HttpStatus.OK);
		
	}

}
