package com.pacvbackend.entidade.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.pacvbackend.entidade.utils.JPAUtils;

public class CondPagtoDAO {
	public void salvar(CondPagto condPagto) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		em.getTransaction().begin();
		
		if (condPagto.getId() != null) {
			em.merge(condPagto);
		} else {
			em.persist(condPagto);
		}
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public void deletar(CondPagto condPagto) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(condPagto);
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public List<CondPagto> recuperar(Long id) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		TypedQuery<CondPagto> t = em.createNamedQuery("SELECT u FROM CondPagto u WHERE id = :cP1", CondPagto.class);
		t.setParameter("cP1", id);
		
		return t.getResultList();
	}
}
