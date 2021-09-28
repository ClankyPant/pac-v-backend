package com.pacvbackend.entidade.condpagto;

import javax.persistence.Entity;

import com.pacvbackend.entidade.utils.AbstractBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CondPagtoEntity extends AbstractBean {

	private String nome;
	
	private Integer qtdeParcelas;
	
	private Double percJuros;
}
