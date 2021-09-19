package com.pacvbackend.entidade.pedido.item;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.pacvbackend.entidade.item.ItemEntity;
import com.pacvbackend.entidade.pedido.PedidoEntity;
import com.pacvbackend.entidade.utils.AbstractBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pedidoItem")
public class PedidoItemEntity extends AbstractBean {
	
	private ItemEntity item;
	
	private PedidoEntity pedido;

	private Integer quantidade;
	
	private Double percDesconto;
	
	private Double vlrUnitarioBruto;
	
	private Double vrlUnitarioLiquido;
}
