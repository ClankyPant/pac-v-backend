package com.pacvbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pacvbackend.entidade.item.condPagto.ItemCondPagtoEntity;
import com.pacvbackend.entidade.item.condPagto.ItemCondPagtoService;


@RestController
@Component
@RequestMapping("/itemCondPagto")
public class ItemCondPagtoController {

	@Autowired
	@SuppressWarnings("unused")
	private ItemCondPagtoService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ItemCondPagtoEntity getItemCondPagto(@RequestParam(value="id") Long id) throws Exception {
		return service.findById(id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void saveItemCondPagto(@RequestBody ItemCondPagtoEntity itemCondPagto) {
		try {
			service.save(itemCondPagto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void deleteItemCondPagto(@RequestParam(value="id") Long id) {
		try {
			service.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void updateItemCondPagto(@RequestParam(value = "id") Long id ,@RequestBody ItemCondPagtoEntity itemCondPagto) {
		try {
			service.save(itemCondPagto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
