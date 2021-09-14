package com.pacvbackend.entidade.usuario;

import javax.persistence.Entity;

import com.pacvbackend.entidade.utils.AbstractBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pedido extends AbstractBean {

	private Usuario usuario;
	
	private long usuario_id;
	
	private double vlrBruto;
	
	private double vrlLiquido;
	
	private double percDesconto;
	
	private String descricao;
}
