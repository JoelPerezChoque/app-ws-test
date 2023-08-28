package com.test.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.test.dto.Empresa;

@Component
public interface EmpresaDao extends CrudRepository<Empresa, Integer> {
	 List<Empresa> findTop3ByOrderByIdDesc();
	 boolean existsByRuc(String ruc);
}
