package com.pacvbackend.entidade.usuario;

public class main {
	
	public static void main(String[] args) {
		try {
			UsuarioDAO t = new UsuarioDAO();
			Usuario user =new Usuario();
			user.setNome("Luis");
			
			t.salvar(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
