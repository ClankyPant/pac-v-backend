package com.pacvbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pacvbackend.entidade.pedido.PedidoEntity;
import com.pacvbackend.entidade.pedido.PedidoService;

@RestController
@Component
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	@SuppressWarnings("unused")
	private PedidoService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public PedidoEntity getPedido(@RequestParam(value="id") Long id) throws Exception {
		return service.getById(id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void savePedido(@RequestBody PedidoEntity pedido) {
		try {
			service.save(pedido);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void deletePedido(@RequestParam(value="id") Long id) {
		try {
			service.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void updatePedido(@RequestParam(value = "id") Long id ,@RequestBody PedidoEntity pedido) {
		try {
			service.save(pedido);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
