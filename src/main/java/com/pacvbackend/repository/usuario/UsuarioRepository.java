package com.pacvbackend.repository.usuario;import org.springframework.data.jpa.repository.JpaRepository;

import com.pacvbackend.entity.usuario.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
	
}
