package com.pacvbackend.entidade.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.pacvbackend.entidade.utils.JPAUtils;

public class PedidoDAO {
	public void salvar(Pedido pedido) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		em.getTransaction().begin();
		
		if (pedido.getId() != null) {
			em.merge(pedido);
		} else {
			em.persist(pedido);
		}
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public void deletar(Pedido pedido) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(pedido);
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public List<Pedido> recuperar(Long id) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		TypedQuery<Pedido> t = em.createNamedQuery("SELECT u FROM Pedido u WHERE id = :p1", Pedido.class);
		t.setParameter("p1", id);
		
		return t.getResultList();
	}
}
