package com.pacvbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pacvbackend.entidade.condpagto.CondPagtoEntity;
import com.pacvbackend.entidade.condpagto.CondPagtoService;


@RestController
@Component
@RequestMapping("/condPagto")
public class CondPagtoController {

	@Autowired
	private CondPagtoService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public CondPagtoEntity getCondPagto(@RequestParam(value="id") Long id) throws Exception {
		return service.findById(id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void saveCondPagto(@RequestBody CondPagtoEntity condPagto) {
		try {
			service.save(condPagto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void deleteCondPagto(@RequestParam(value="id") Long id) {
		try {
			service.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void updateCondPagto(@RequestParam(value = "id") Long id ,@RequestBody CondPagtoEntity condPagto) {
		try {
			service.save(condPagto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
