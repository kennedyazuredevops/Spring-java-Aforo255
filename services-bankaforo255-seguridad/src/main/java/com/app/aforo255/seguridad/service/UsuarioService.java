package com.app.aforo255.seguridad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.app.aforo255.seguridad.dao.UsuarioDao;
import com.app.aforo255.seguridad.models.entity.Usuario;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.*;

@Service
public class UsuarioService implements UserDetailsService {
 
	private Logger log =LoggerFactory.getLogger(UsuarioService.class);
	@Autowired
	private UsuarioDao client ;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = client.findByUsername(username);
		
		if (usuario==null) {
			throw new UsernameNotFoundException("Error login");
			
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(autority -> log.info("Role: " + autority.getAuthority()))
				.collect(Collectors.toList());	
	
				log.info("Usuario autenticado: "+ username);			
	
				return new User(usuario.getUsername(),usuario.getPassword(),usuario.getEnabled(),true, true, true,authorities);
	}

}
