package com.pacvbackend.entidade.condpagto;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.pacvbackend.entidade.utils.AbstractBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "condPagto")
public class CondPagtoEntity extends AbstractBean{

	private String nome;
	
	private Integer qtdeParcelas;
	
	private Double percJuros;
}
