package br.com.pos.puc.getCar.config.security;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.pos.puc.getCar.domain.Usuario;
import br.com.pos.puc.getCar.repository.UsuarioRepository;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter{

	private TokenService tokenService;
	private UsuarioRepository repository;

	/**
	 * @param tokenService
	 */
	public AutenticacaoViaTokenFilter(TokenService tokenService, UsuarioRepository repository) {
		this.tokenService = tokenService;
		this.repository = repository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request);
		boolean valido = tokenService.isValido(token);
		
		if(valido){
			autenticarCliente(token);
		}
		
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
//		response.setHeader("Access-Control-Allow-Origin", "http://getcar.com.s3-website-us-west-2.amazonaws.com");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "4800");


        if (request.getMethod().equals(HttpMethod.OPTIONS.name())) {
            response.setHeader("Access-Control-Allow-Headers", "origin, x-requested-with, content-type, x-custom-header-here, authorization, x-authorization");
            response.setHeader("Access-Control-Expose-Headers", "*");
            
        	response.setStatus(HttpStatus.OK.value());
        } else {
            response.setHeader("Access-Control-Allow-Credentials", "true");
      		filterChain.doFilter(request, response);
        }
        
	}

	private void autenticarCliente(String token) {
		Long idUsuario = tokenService.getIdUsuario(token);
		Usuario usuario =  repository.findById(idUsuario).get();
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
	private String recuperarToken(HttpServletRequest request) {	
        String token= request.getHeader("Authorization");
        System.out.println("Token: " + token);

		if(token == null || token.isEmpty() || !token.startsWith("Bearer")) {
			return null;
		}
		
		return token.substring(7, token.length());
	}

}
