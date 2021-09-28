package com.pacvbackend.entidade.pedido.item;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.pacvbackend.entidade.item.ItemEntity;
import com.pacvbackend.entidade.pedido.PedidoEntity;
import com.pacvbackend.entidade.utils.AbstractBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PedidoItemEntity extends AbstractBean {
	
	@OneToOne
	private ItemEntity item;
	
	@OneToOne
	private PedidoEntity pedido;

	private Integer quantidade;
	
	private Double percDesconto;
	
	private Double vlrUnitarioBruto;
	
	private Double vrlUnitarioLiquido;
}
