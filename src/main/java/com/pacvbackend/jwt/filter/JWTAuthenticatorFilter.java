package com.pacvbackend.jwt.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pacvbackend.entidade.usuario.UsuarioEntity;
import com.pacvbackend.jwt.model.UserDetailModel;

public class JWTAuthenticatorFilter extends UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authenticationManager;
	
	public static final String AUTH_PASS = "mLht1zfYuYu1uWOvUT3p4049kMrmNKEa8HvQ9ivLJu4=";

	public JWTAuthenticatorFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		try {
			UsuarioEntity usuarioEntity = new ObjectMapper().readValue(request.getInputStream(), UsuarioEntity.class);
			
			return this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
						usuarioEntity.getLogin(),
						usuarioEntity.getPassword(),
						new ArrayList<GrantedAuthority>()
					));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to authenticate");
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		UserDetailModel userDetail = (UserDetailModel) authResult.getPrincipal();
		String token = JWT.create()
						.withSubject(userDetail.getUsername())
						.withExpiresAt(new Date(System.currentTimeMillis() + 600_000))
						.sign(Algorithm.HMAC512(AUTH_PASS));
		
		response.getWriter().write(token);
		response.getWriter().flush();
	}
}
