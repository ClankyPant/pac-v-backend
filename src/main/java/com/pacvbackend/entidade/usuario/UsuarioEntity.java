package com.pacvbackend.entidade.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.pacvbackend.entidade.utils.AbstractBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UsuarioEntity extends AbstractBean {
	
	private String nome;
	
	@Column(unique = true)
	private String login;
	
	private String password;
	
	private String email;
	
	private String endCep;
	
	private String endereco;
	
	private String endCidade;

	private String endComplemento;
	
	private Integer endNumero;
	
	private Integer nivelAcesso;

}
