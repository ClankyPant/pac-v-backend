package com.pacvbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pacvbackend.entidade.item.imagem.ItemImagemEntity;
import com.pacvbackend.entidade.item.imagem.ItemImagemService;


@RestController
@Component
@RequestMapping("/itemImagem")
public class ItemImagemController {

	@Autowired
	@SuppressWarnings("unused")
	private ItemImagemService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getItemImagem() {
		return "Teste";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String saveItemImagem(@RequestBody ItemImagemEntity itemImagem) {
		return "Teste";
	}
	
	@RequestMapping(value = "/:id", method = RequestMethod.DELETE)
	public String deleteItemImagem(@PathVariable(value="id") Long id) {
		return "Teste";
	}
	
	@RequestMapping(value = "/:id", method = RequestMethod.PUT)
	public String updateItemImagem(@PathVariable(value = "id") Long id ,@RequestBody ItemImagemEntity itemImagem) {
		return "Teste";
	}
}
