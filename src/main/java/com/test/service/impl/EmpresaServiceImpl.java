package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.EmpresaDao;
import com.test.dto.Empresa;
import com.test.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaDao repository;
	
	@Override
	public List<Empresa> getThreeLateEmpresa() {
		return repository.findTop3ByOrderByIdDesc();
	}

	@Override
	public Empresa saveEmpresa(Empresa empresa) {	
		if (repository.existsByRuc(empresa.getRuc())) {
            throw new IllegalArgumentException("El RUC ya esta registrado!");
        }
		return repository.save(empresa);
	}

}
