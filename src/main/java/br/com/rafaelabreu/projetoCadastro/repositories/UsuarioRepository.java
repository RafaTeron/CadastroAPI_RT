package br.com.rafaelabreu.projetoCadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rafaelabreu.projetoCadastro.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
