package com.pacvbackend.entidade.condpagto;

import org.springframework.beans.factory.annotation.Autowired;

public class CondPagtoService {
	
	@Autowired
	private CondPagtoRepository repository;
	
	public void save(CondPagtoEntity condPagto) throws Exception {
		this.repository.save(condPagto);
	}
	
	public void delete(CondPagtoEntity condPagto) throws Exception {
		this.repository.delete(condPagto);
	}
	
	public CondPagtoEntity findById(Long id) throws Exception {		
		return this.repository.findById(id).get();
	}
}
