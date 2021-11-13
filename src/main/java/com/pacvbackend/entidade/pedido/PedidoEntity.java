package com.pacvbackend.entidade.pedido;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.pacvbackend.entidade.usuario.UsuarioEntity;
import com.pacvbackend.entidade.utils.AbstractBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PedidoEntity extends AbstractBean {
	
	private Double vlrBruto;
	
	private Double vrlLiquido;
	
	private Double percDesconto;
	
	private String descricao;

	@OneToOne
	private UsuarioEntity usuario;
}
