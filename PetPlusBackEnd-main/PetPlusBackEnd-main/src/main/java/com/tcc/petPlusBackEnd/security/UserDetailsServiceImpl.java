package com.tcc.petPlusBackEnd.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tcc.petPlusBackEnd.model.Cliente;
import com.tcc.petPlusBackEnd.model.Veterinario;
import com.tcc.petPlusBackEnd.repository.ClienteRepository;
import com.tcc.petPlusBackEnd.repository.VeterinarioRepository;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService  {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private VeterinarioRepository vetRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		if(clienteRepository.findByEmail(userName).isPresent()) {
			Optional<Cliente> user = clienteRepository.findByEmail(userName);
			return user.map(UserDetailsImpl::new).get();
		}else {
			Optional<Veterinario> user = vetRepository.findOneByEmail(userName);
			return user.map(UserDetailsImpl::new).get();
		}
		
	}

}
