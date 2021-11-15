package com.pacvbackend.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pacvbackend.jwt.filter.JWTAuthenticatorFilter;
import com.pacvbackend.jwt.filter.JWTValidatorFilter;
import com.pacvbackend.jwt.service.UserDetailServiceImpl;

@EnableWebSecurity
public class JWTConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailServiceImpl detailUserService;
	
	@Autowired
	private PasswordEncoder passwordEnconder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(detailUserService).passwordEncoder(passwordEnconder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/login")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.addFilter(new JWTAuthenticatorFilter(authenticationManager()))
		.addFilter(new JWTValidatorFilter(authenticationManager()))
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.cors()
		.configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS");
			}
		};
	}
}
