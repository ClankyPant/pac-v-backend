package com.pacvbackend.jwt.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTValidatorFilter extends BasicAuthenticationFilter {

	public static final String HEADER_ATTR = "Authorization";
	public static final String HEADER_PREFIX = "Bearer ";
	
	public JWTValidatorFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String attr = request.getHeader(HEADER_ATTR);
		
		if (attr == null || attr.startsWith(HEADER_PREFIX) == false) {
			chain.doFilter(request, response);
			return;
		}
		
		String token = attr.replace(HEADER_PREFIX, "");
		UsernamePasswordAuthenticationToken authToken = getAuthenticationToken(token);
		
		SecurityContextHolder.getContext().setAuthentication(authToken);
		chain.doFilter(request, response);
	}
	
	private UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {
		
		String userName = JWT.require(Algorithm.HMAC512(JWTAuthenticatorFilter.AUTH_PASS)).build().verify(token).getSubject();
		
		if (userName == null) {
			return null;
		}
		
		return new UsernamePasswordAuthenticationToken(userName, null, new ArrayList<GrantedAuthority>());
	}
}
