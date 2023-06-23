package com.tcc.petPlusBackEnd.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.tcc.petPlusBackEnd.model.Veterinario;
import com.tcc.petPlusBackEnd.repository.VeterinarioRepository;

@Service
public class VetDetailsServiceImpl /* implements UserDetailsService */ {

	@Autowired
	private VeterinarioRepository vetRepository;

	/*
	 * @Override public UserDetails loadUserByUsername(String userName) throws
	 * UsernameNotFoundException { Optional<Veterinario> user =
	 * vetRepository.findOneByNome(userName); user.orElseThrow(() -> new
	 * UsernameNotFoundException(userName + "not found")); return
	 * user.map(VetDetailsImpl::new).get(); }
	 */

}
