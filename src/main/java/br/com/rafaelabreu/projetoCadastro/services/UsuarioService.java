package br.com.rafaelabreu.projetoCadastro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelabreu.projetoCadastro.entities.Usuario;
import br.com.rafaelabreu.projetoCadastro.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}

}
