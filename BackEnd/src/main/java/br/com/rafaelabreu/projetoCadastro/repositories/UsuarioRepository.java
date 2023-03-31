package br.com.rafaelabreu.projetoCadastro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rafaelabreu.projetoCadastro.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Optional<Usuario> findByLogin(String login);

}
