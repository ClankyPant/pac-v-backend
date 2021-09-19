package com.pacvbackend.entidade.pedido.item;

import org.springframework.beans.factory.annotation.Autowired;

public class PedidoItemService {
	
	@Autowired
	private PedidoItemRepository repository;
	
	public void save(PedidoItemEntity pedidoItem) throws Exception {
		this.repository.save(pedidoItem);
	}
	
	public void delete(PedidoItemEntity pedidoItem) throws Exception {
		this.repository.delete(pedidoItem);
	}
	
	public PedidoItemEntity findById(Long id) throws Exception {
		return this.repository.findById(id).get();
	}
}
