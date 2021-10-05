package com.pacvbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pacvbackend.entidade.usuario.UsuarioEntity;
import com.pacvbackend.entidade.usuario.UsuarioService;

@RestController
@Component
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	@SuppressWarnings("unused")
	private UsuarioService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public UsuarioEntity getUsuario(@RequestParam(value="id") Long id) throws Exception {
			return service.getById(id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void saveUsuario(@RequestBody UsuarioEntity user) {
		try {
			service.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public void deleteUsuario(@RequestParam(value="id") Long id) {
		try {
			service.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public void updateUsuario(@RequestParam(value = "id") Long id ,@RequestBody UsuarioEntity user) {
		try {
			service.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
