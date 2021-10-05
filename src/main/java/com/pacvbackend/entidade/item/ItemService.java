package com.pacvbackend.entidade.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemService {
	
	@Autowired
	private ItemRepository repository;
	
	public void save(ItemEntity item) throws Exception {
		this.repository.save(item);
	}
	
	public void deletar(Long id) throws Exception {
		this.repository.deleteById(id);;
	}

	public ItemEntity findById(Long id) throws Exception {
		return this.repository.findById(id).get();
	}
}
