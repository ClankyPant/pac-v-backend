package com.pacvbackend.entidade.usuario;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public void save(UsuarioEntity user) throws Exception {
		user.setPassword(this.encoder.encode(user.getPassword()));
		repository.save(user);
	}
	
	public void delete(Long id) throws Exception {
		repository.deleteById(id);
	}
	
	public UsuarioEntity getById(Long id) throws Exception {
		return repository
				.findAll()
				.stream()
				.filter(user -> user.getId().equals(id))
				.findFirst()
				.orElse(new UsuarioEntity());
	}
	
	public Optional<UsuarioEntity> getByUsername(String userName) throws Exception {
		return repository
				.findAll()
				.stream()
				.filter(user -> user.getLogin().equals(userName))
				.findFirst();
	}
}
