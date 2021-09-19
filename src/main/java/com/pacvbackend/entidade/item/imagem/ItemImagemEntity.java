package com.pacvbackend.entidade.item.imagem;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.pacvbackend.entidade.item.ItemEntity;
import com.pacvbackend.entidade.utils.AbstractBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "itemImagem")
public class ItemImagemEntity extends AbstractBean {
	
	private Integer ordem;
	
	private String imagem;
	
	private ItemEntity item;
}