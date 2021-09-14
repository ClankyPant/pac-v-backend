package com.pacvbackend.entidade.usuario;

import javax.persistence.Entity;

import com.pacvbackend.entidade.utils.AbstractBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ItemImagem extends AbstractBean{
	
	private Item item;

	private long item_id;
	
	private String imagem;
	
	private int ordem;
}
