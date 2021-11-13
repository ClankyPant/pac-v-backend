package com.pacvbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pacvbackend.entidade.item.ItemEntity;
import com.pacvbackend.entidade.item.ItemService;

@RestController
@Component
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ItemEntity getItem(@RequestParam(value="id") Long id) throws Exception {
		return service.findById(id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void saveItem(@RequestBody ItemEntity item) {
		try {
			service.save(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void deleteItem(@RequestParam(value="id") Long id) {
		try {
			service.deletar(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void updateItem(@RequestParam(value = "id") Long id ,@RequestBody ItemEntity item) {
		try {
			service.save(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
