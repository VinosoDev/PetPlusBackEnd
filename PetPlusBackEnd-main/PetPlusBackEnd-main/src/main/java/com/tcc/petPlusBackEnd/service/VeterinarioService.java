package com.tcc.petPlusBackEnd.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tcc.petPlusBackEnd.model.UsuarioLogin;
import com.tcc.petPlusBackEnd.model.Veterinario;
import com.tcc.petPlusBackEnd.model.VeterinarioLogin;
import com.tcc.petPlusBackEnd.repository.VeterinarioRepository;

@Service
public class VeterinarioService {
	@Autowired
	private VeterinarioRepository vetRepository;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public Veterinario cadastrarVeterinario(Veterinario veterinario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(veterinario.getSenha());
		veterinario.setSenha(senhaEncoder);
		
		return vetRepository.save(veterinario);
	}
	
	public Optional<UsuarioLogin> Logar(Optional <UsuarioLogin> user){ 
		Optional<Veterinario> usuario = vetRepository.findOneByEmail(user.get().getEmail());
		
		if(usuario.isPresent()) {
			
			if(encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
				String auth = user.get().getEmail() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				
				user.get().setToken(authHeader);
				user.get().setNome(usuario.get().getNome());
				user.get().setImagem(usuario.get().getImagem());
				
				return user;
			}
		}
		return null;
	}
	
	public Optional<Veterinario> atualizarVeterinario(Veterinario veterinario) {
        Optional<Veterinario> buscaVeterinario = vetRepository.findById(veterinario.getIdVeterinario());

        if(buscaVeterinario.isPresent()) {
            buscaVeterinario.get().setIdVeterinario(buscaVeterinario.get().getIdVeterinario());
            buscaVeterinario.get().setNome(veterinario.getNome());
            buscaVeterinario.get().setImagem(veterinario.getImagem());
            buscaVeterinario.get().setRg(veterinario.getRg());
            buscaVeterinario.get().setTelefone(veterinario.getTelefone());
            buscaVeterinario.get().setLogradouro(veterinario.getLogradouro());
            buscaVeterinario.get().setNumero(veterinario.getNumero());
            buscaVeterinario.get().setBairro(veterinario.getBairro());
            buscaVeterinario.get().setCidade(veterinario.getCidade());
            buscaVeterinario.get().setUf(veterinario.getUf());
            buscaVeterinario.get().setCrmv(veterinario.getCrmv());
            buscaVeterinario.get().setSenha(criptografarSenha(veterinario.getSenha()));

            veterinario = buscaVeterinario.get();

        }
        return Optional.of(vetRepository.save(veterinario));
    }
	
	private String criptografarSenha(String senha) {
        String senhaEncoder = encoder.encode(senha);
        return senhaEncoder;
    }

}
