package com.pacvbackend.entidade.condpagto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CondPagtoService {
	
	@Autowired
	private CondPagtoRepository repository;
	
	public void save(CondPagtoEntity condPagto) throws Exception {
		this.repository.save(condPagto);
	}
	
	public void delete(Long id) throws Exception {
		this.repository.deleteById(id);
	}
	
	public CondPagtoEntity findById(Long id) throws Exception {		
		return this.repository.findById(id).get();
	}
}
