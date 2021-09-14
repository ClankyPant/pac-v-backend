package com.pacvbackend.entidade.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.pacvbackend.entidade.utils.JPAUtils;

public class ItemImagemDAO {
	public void salvar(ItemImagem itemImagem) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		em.getTransaction().begin();
		
		if (itemImagem.getId() != null) {
			em.merge(itemImagem);
		} else {
			em.persist(itemImagem);
		}
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public void deletar(ItemImagem itemImagem) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(itemImagem);
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public List<ItemImagem> recuperar(Long id) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		TypedQuery<ItemImagem> t = em.createNamedQuery("SELECT u FROM ItemImagem u WHERE id = :i1", ItemImagem.class);
		t.setParameter("i1", id);
		
		return t.getResultList();
	}
}
