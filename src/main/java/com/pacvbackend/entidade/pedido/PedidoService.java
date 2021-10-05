package com.pacvbackend.entidade.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public void save(PedidoEntity pedido) throws Exception {
		this.repository.save(pedido);
	}
	
	public void delete(Long id) throws Exception {
		this.repository.deleteById(id);
	}
	
	public PedidoEntity getById(Long id) throws Exception {
		return this.repository.findById(id).get();	
	}
}
