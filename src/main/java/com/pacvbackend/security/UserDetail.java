package com.pacvbackend.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pacvbackend.entidade.usuario.UsuarioEntity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@SuppressWarnings("serial")
public class UserDetail implements UserDetails {

	private Optional<UsuarioEntity> usuarioEntity;
	
	public UserDetail(Optional<UsuarioEntity> usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<GrantedAuthority>();
	}

	@Override
	public String getPassword() {
		return this.usuarioEntity.orElse(new UsuarioEntity()).getPassword();
	}

	@Override
	public String getUsername() {
		return this.usuarioEntity.orElse(new UsuarioEntity()).getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
