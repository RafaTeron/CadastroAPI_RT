package br.com.rafaelabreu.projetoCadastro.services;

import java.util.List;
import java.util.Optional;

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
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj =repository.findById(id);
		return obj.get();
	}
	
	public Usuario save(Usuario usuario) {
	    return repository.save(usuario);
	}
	
	public Usuario update(Long id, Usuario obj) {
	    Usuario entity = repository.getReferenceById(id);
	    updateData(entity, obj);
	    return repository.save(entity);
	}
	
	private void updateData(Usuario entity, Usuario obj) {
		entity.setAniversario(obj.getAniversario());
		entity.setCelular(obj.getCelular());
		entity.setCep(obj.getCep());
		entity.setCpf(obj.getCpf());
		entity.setEmail(obj.getEmail());
		entity.setGenero(obj.getGenero());
		entity.setSenha(obj.getSenha());
		entity.setUsuario(obj.getUsuario());
	}

	public void deleteById(Long id) {
	    repository.deleteById(id);
	}

}
