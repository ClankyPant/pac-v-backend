package com.pacvbackend.entidade.item.imagem;

import org.springframework.beans.factory.annotation.Autowired;

public class ItemImagemService {
	
	@Autowired
	private ItemImagemRepository repository;
	
	public void save(ItemImagemEntity itemImagem) throws Exception {
		this.repository.save(itemImagem);
	}
	
	public void delete(ItemImagemEntity itemImagem) throws Exception {
		this.repository.delete(itemImagem);
	}
	
	public ItemImagemEntity recuperar(Long id) throws Exception {
		return this.repository.findById(id).get(); 
	}
}
