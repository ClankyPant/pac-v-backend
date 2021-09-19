package com.pacvbackend.entidade.pedido;

import org.springframework.beans.factory.annotation.Autowired;

public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public void save(PedidoEntity pedido) throws Exception {
		this.repository.save(pedido);
	}
	
	public void delete(PedidoEntity pedido) throws Exception {
		this.repository.delete(pedido);
	}
	
	public PedidoEntity getById(Long id) throws Exception {
		return this.repository.findById(id).get();	
	}
}
