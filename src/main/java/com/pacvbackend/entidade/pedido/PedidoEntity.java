package com.pacvbackend.entidade.pedido;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.pacvbackend.entidade.usuario.UsuarioEntity;
import com.pacvbackend.entidade.utils.AbstractBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pedido")
public class PedidoEntity extends AbstractBean {
	
	private Double vlrBruto;
	
	private Double vrlLiquido;
	
	private Double percDesconto;
	
	private String descricao;

	private UsuarioEntity usuario;
}
