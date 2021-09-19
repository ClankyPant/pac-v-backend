package com.pacvbackend.entidade.item.condPagto;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.pacvbackend.entidade.condpagto.CondPagtoEntity;
import com.pacvbackend.entidade.item.ItemEntity;
import com.pacvbackend.entidade.utils.AbstractBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "itemCondPagto")
public class ItemCondPagtoEntity extends AbstractBean {
	
	private ItemEntity item;

	private CondPagtoEntity condPagto;
	
	private double percJuros;
}
