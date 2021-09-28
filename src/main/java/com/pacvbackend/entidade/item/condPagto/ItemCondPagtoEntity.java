package com.pacvbackend.entidade.item.condPagto;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.pacvbackend.entidade.condpagto.CondPagtoEntity;
import com.pacvbackend.entidade.item.ItemEntity;
import com.pacvbackend.entidade.utils.AbstractBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ItemCondPagtoEntity extends AbstractBean {
	
	@OneToOne
	private ItemEntity item;
	
	@OneToOne
	private CondPagtoEntity condPagto;
	
	private double percJuros;
}
