package com.pacvbackend.entidade.usuario;

public class Main {
	
	public static void main(String[] args) {
		try {
			UsuarioService t = new UsuarioService();
			UsuarioEntity user = new UsuarioEntity();
			user.setNome("Luis");
			
			t.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
