package com.pacvbackend.entidade.usuario;

import javax.persistence.EntityManager;

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
		
		em.getTransaction().begin();;
		
		em.remove(user);
		
		em.getTransaction().commit();
		
		em.close();
	}
}
