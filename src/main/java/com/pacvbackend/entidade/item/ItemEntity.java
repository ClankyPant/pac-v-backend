package com.pacvbackend.entidade.item;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.pacvbackend.entidade.utils.AbstractBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "item")
public class ItemEntity extends AbstractBean {
	
	private String nome;
	
	private Double descricao;
	
	private Double percDesconto;
	
	private Double vrlUnitarioBruto;
}
