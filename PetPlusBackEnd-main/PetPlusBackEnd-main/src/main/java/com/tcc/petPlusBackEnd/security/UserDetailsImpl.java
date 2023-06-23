package com.tcc.petPlusBackEnd.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tcc.petPlusBackEnd.model.Cliente;
import com.tcc.petPlusBackEnd.model.UsuarioLogin;
import com.tcc.petPlusBackEnd.model.Veterinario;

public class UserDetailsImpl implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	
	public UserDetailsImpl(Cliente user) {
		this.userName = user.getNome();
		this.password = user.getSenha();
	}
	
	public UserDetailsImpl(Veterinario user) {
		this.userName = user.getNome();
		this.password = user.getSenha();
	}
	
	
	public UserDetailsImpl() {}
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
