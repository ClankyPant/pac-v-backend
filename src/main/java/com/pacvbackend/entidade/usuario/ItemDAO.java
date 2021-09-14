package com.pacvbackend.entidade.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.pacvbackend.entidade.utils.JPAUtils;

public class ItemDAO {
	public void salvar(Item item) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		em.getTransaction().begin();
		
		if (item.getId() != null) {
			em.merge(item);
		} else {
			em.persist(item);
		}
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public void deletar(Item item) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(item);
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public List<Item> recuperar(Long id) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		TypedQuery<Item> t = em.createNamedQuery("SELECT u FROM Item u WHERE id = :i1", Item.class);
		t.setParameter("i1", id);
		
		return t.getResultList();
	}
}
