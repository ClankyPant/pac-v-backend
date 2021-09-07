package com.pacvbackend.entidade.usuario;

import javax.persistence.Entity;

import com.pacvbackend.entidade.utils.AbstractBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuario extends AbstractBean {
	
	private String nome;
	
	private String login;
	
	private String password;
	
	private String email;
	
	private Integer nivelAcesso;

}
