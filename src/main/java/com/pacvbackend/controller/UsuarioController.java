package com.pacvbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pacvbackend.entidade.usuario.UsuarioEntity;
import com.pacvbackend.entidade.usuario.UsuarioService;
import com.pacvbackend.model.ResponseRequestModel;

@RestController
@Component
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public UsuarioEntity getUsuario(@RequestParam(value="id") Long id) throws Exception {
		return service.getById(id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<ResponseRequestModel> saveUsuario(@RequestBody UsuarioEntity user) {
		ResponseRequestModel result = new ResponseRequestModel();
		
		try {
			service.save(user);
			result = new ResponseRequestModel(null, HttpStatus.CREATED.value(), "Usuario cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			result = new ResponseRequestModel(null, HttpStatus.BAD_REQUEST.value(), e.getMessage());
		}
		
		return new ResponseEntity<ResponseRequestModel>(result, null, HttpStatus.OK);
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
			service.update(id, user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
