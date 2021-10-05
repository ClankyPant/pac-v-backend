package com.pacvbackend.entidade.item.condPagto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemCondPagtoService {
	
	@Autowired
	private ItemCondPagtoRepository repository;
	
	public void save(ItemCondPagtoEntity itemCondPagto) throws Exception {
		this.repository.save(itemCondPagto);
	}
	
	public void delete(Long id) throws Exception {
		this.repository.deleteById(id);
	}
	
	public ItemCondPagtoEntity findById(Long id) throws Exception {
		return this.repository.findById(id).get();
	}
}
