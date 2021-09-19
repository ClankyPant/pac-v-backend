package com.pacvbackend.entidade.item.condPagto;

import org.springframework.beans.factory.annotation.Autowired;

public class ItemCondPagtoService {
	
	@Autowired
	private ItemCondPagtoRepository repository;
	
	public void save(ItemCondPagtoEntity itemCondPagto) throws Exception {
		this.repository.save(itemCondPagto);
	}
	
	public void delete(ItemCondPagtoEntity itemCondPagto) throws Exception {
		this.repository.delete(itemCondPagto);
	}
	
	public ItemCondPagtoEntity findById(Long id) throws Exception {
		return this.repository.findById(id).get();
	}
}
