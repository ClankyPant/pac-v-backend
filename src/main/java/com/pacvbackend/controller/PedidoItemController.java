package com.pacvbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pacvbackend.entidade.pedido.item.PedidoItemEntity;
import com.pacvbackend.entidade.pedido.item.PedidoItemService;

@RestController
@Component
@RequestMapping("/pedidoItem")
public class PedidoItemController {

	@Autowired
	@SuppressWarnings("unused")
	private PedidoItemService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getPedidoItem() {
		return "Teste";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String savePedidoItem(@RequestBody PedidoItemEntity pedidoItem) {
		return "Teste";
	}
	
	@RequestMapping(value = "/:id", method = RequestMethod.DELETE)
	public String deletePedidoItem(@PathVariable(value="id") Long id) {
		return "Teste";
	}
	
	@RequestMapping(value = "/:id", method = RequestMethod.PUT)
	public String updatePedidoItem(@PathVariable(value = "id") Long id ,@RequestBody PedidoItemEntity pedidoItem) {
		return "Teste";
	}
}
