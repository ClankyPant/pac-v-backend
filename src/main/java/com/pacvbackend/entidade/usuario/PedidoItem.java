package com.pacvbackend.entidade.usuario;

import javax.persistence.Entity;

import com.pacvbackend.entidade.utils.AbstractBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PedidoItem extends AbstractBean {
	
	private Pedido pedido;
	
	private long pedido_id;
	
	private Item item;
	
	private long item_id;
	
	private Integer quantidade;
	
	private double vlrUnitarioBruto;
	
	private double vrlUnitarioLiquido;
	
	private double percDesconto;
}
