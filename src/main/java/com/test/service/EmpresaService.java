package com.test.service;

import java.util.List;

import com.test.dto.Empresa;

public interface EmpresaService {
	public List<Empresa>getThreeLateEmpresa();
	public Empresa saveEmpresa(Empresa empresa);
}
