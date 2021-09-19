package com.pacvbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pacvbackend.entity.usuario.UsuarioEntity;
import com.pacvbackend.service.usuario.UsuarioService;

@RestController
@Component
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	@SuppressWarnings("unused")
	private UsuarioService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getUsuario() {
		
		return "TEste";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String saveUsuario(@RequestBody UsuarioEntity user) {
		return "TEste";
	}
	
	@RequestMapping(value = "/:id", method = RequestMethod.DELETE)
	public String deleteUsuario(@PathVariable(value="id") Long id) {
		return "TEste";
	}
	
	@RequestMapping(value = "/:id", method = RequestMethod.PUT)
	public String updateUsuario(@PathVariable(value = "id") Long id ,@RequestBody UsuarioEntity user) {
		return "TEste";
	}
}
