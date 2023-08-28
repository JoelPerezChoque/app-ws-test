package com.test.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseError {
	private String codigo;
	private List<Violiation>violations=new ArrayList<>();
	public ResponseError() {
	}
	
	public ResponseError(String codigo, List<Violiation> violations) {
		super();
		this.codigo = codigo;
		this.violations = violations;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public List<Violiation> getViolations() {
		return violations;
	}
	public void setViolations(List<Violiation> violations) {
		this.violations = violations;
	}
	
	
	
	
}
