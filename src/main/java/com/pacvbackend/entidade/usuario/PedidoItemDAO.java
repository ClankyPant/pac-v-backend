package com.pacvbackend.entidade.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.pacvbackend.entidade.utils.JPAUtils;

public class PedidoItemDAO {
	public void salvar(PedidoItem pedidoItem) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		em.getTransaction().begin();
		
		if (pedidoItem.getId() != null) {
			em.merge(pedidoItem);
		} else {
			em.persist(pedidoItem);
		}
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public void deletar(PedidoItem pedidoItem) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(pedidoItem);
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public List<PedidoItem> recuperar(Long id) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		TypedQuery<PedidoItem> t = em.createNamedQuery("SELECT u FROM PedidoItem u WHERE id = :pI1", PedidoItem.class);
		t.setParameter("pI1", id);
		
		return t.getResultList();
	}
}
