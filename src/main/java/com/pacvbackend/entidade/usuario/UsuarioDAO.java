package com.pacvbackend.entidade.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.pacvbackend.entidade.utils.JPAUtils;

public class UsuarioDAO {

	public void salvar(Usuario user) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		em.getTransaction().begin();
		
		if (user.getId() != null) {
			em.merge(user);
		} else {
			em.persist(user);
		}
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public void deletar(Usuario user) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(user);
		
		em.getTransaction().commit();
		
		em.close();
	}
	
	public List<Usuario> recuperar(Long id) throws Exception {
		EntityManager em = JPAUtils.getEntityManager();
		
		TypedQuery<Usuario> t = em.createNamedQuery("SELECT u FROM Usuario u WHERE id = :p1", Usuario.class);
		t.setParameter("p1", id);
		
		return t.getResultList();
	}
}
