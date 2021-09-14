package com.pacvbackend.entidade.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.pacvbackend.entidade.utils.JPAUtils;

public class ItemCondPagtoDAO {
	public void salvar(ItemCondPagto itemCondPagto) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		em.getTransaction().begin();
		
		if (itemCondPagto.getId() != null) {
			em.merge(itemCondPagto);
		} else {
			em.persist(itemCondPagto);
		}
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public void deletar(ItemCondPagto itemCondPagto) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(itemCondPagto);
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public List<ItemCondPagto> recuperar(Long id) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		TypedQuery<ItemCondPagto> t = em.createNamedQuery("SELECT u FROM ItemCondPagto u WHERE id = :iCP1", ItemCondPagto.class);
		t.setParameter("iCP1", id);
		
		return t.getResultList();
	}
}
