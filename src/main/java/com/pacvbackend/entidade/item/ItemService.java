package com.pacvbackend.entidade.item;

import org.springframework.beans.factory.annotation.Autowired;

public class ItemService {
	
	@Autowired
	private ItemRepository repository;
	
	public void save(ItemEntity item) throws Exception {
		this.repository.save(item);
	}
	
	public void deletar(ItemEntity item) throws Exception {
		this.repository.delete(item);
	}
	
	public ItemEntity findById(Long id) throws Exception {
		return this.repository.findById(id).get();
	}
}
