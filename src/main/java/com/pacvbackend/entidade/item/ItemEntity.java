package com.pacvbackend.entidade.item;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.pacvbackend.entidade.utils.AbstractBean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ItemEntity extends AbstractBean {
	
	private String nome;
	
	private String descricao;
	
	private Integer categoria = ItemCatoegoryEnum.JOGOS.codigo;
	
	private Double preco;
	
	private Double percDesconto;
	
	@Column(columnDefinition = "TEXT")
	private String base64;
	
	@AllArgsConstructor
	public enum ItemCatoegoryEnum {
		JOGOS(10),
		CONSOLE(20),
		ACESSORIOS(30),
		DECORACAO(40);
		
		public Integer codigo;
	}
}
