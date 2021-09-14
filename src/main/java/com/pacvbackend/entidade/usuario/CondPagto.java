package com.pacvbackend.entidade.usuario;

import javax.persistence.Entity;

import com.pacvbackend.entidade.utils.AbstractBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CondPagto extends AbstractBean{

	private String nome;
	
	private Integer qtdeParcelas;
	
	private double percJuros;
}
