package com.pacvbackend.entidade.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public void save(UsuarioEntity user) throws Exception {
		validateUser(user);
		
		user.setPassword(this.encoder.encode(user.getPassword()));
		repository.save(user);		
	}

	public void validateUser(UsuarioEntity user) throws Exception {
		List<String> emptyFieldList = new ArrayList<String>();
		
		if (StringUtils.isEmpty(user.getLogin())) { 
			emptyFieldList.add("login");
		}
		
		if (StringUtils.isEmpty(user.getPassword())) { 
			emptyFieldList.add("password");			
		}
		
		if (StringUtils.isEmpty(user.getNome())) { 
			emptyFieldList.add("nome");			
		}
		
		if (CollectionUtils.isNotEmpty(emptyFieldList)) {
			throw new Exception("Os campos " + StringUtils.join(emptyFieldList, ", ") + " precisam ser preenchidos!");
		}
		
		UsuarioEntity existingUser = repository.findAll().stream().filter(userStream -> userStream.getLogin().equals(user.getLogin())).findAny().orElse(null);
		
		if (existingUser != null) {
			throw new DuplicateKeyException("O login " + user.getLogin() + " já está sendo usado!");
		}
	}
	public void update(Long id, UsuarioEntity user) {
		UsuarioEntity usuario = this.repository.getById(id);
		
		if (usuario != null) {
			usuario.setNome(user.getNome());
			usuario.setLogin(user.getLogin());
			usuario.setPassword(this.encoder.encode(user.getPassword()));
			usuario.setEmail(user.getEmail());
			
			this.repository.save(usuario);
		}
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
