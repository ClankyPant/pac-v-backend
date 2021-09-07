package com.pacvbackend.entidade.utils;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractBean {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
}
