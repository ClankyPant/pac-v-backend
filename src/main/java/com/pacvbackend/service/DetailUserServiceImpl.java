package com.pacvbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pacvbackend.entidade.usuario.UsuarioService;
import com.pacvbackend.security.UserDetail;

@Service
public class DetailUserServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			return new UserDetail(this.usuarioService.getByUsername(username));
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("User not found!");
		}
	}

}
