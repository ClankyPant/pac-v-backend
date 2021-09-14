package com.pacvbackend.entidade.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public void save(UsuarioEntity user) throws Exception {
		repository.save(user);
	}
	
	public void delete(UsuarioEntity user) throws Exception {
		repository.delete(user);
	}
	
	public UsuarioEntity getById(Long id) throws Exception {
		return repository
				.findAll()
				.stream()
				.filter(user -> user.getId().equals(id))
				.findFirst()
				.orElse(null);
	}
}
