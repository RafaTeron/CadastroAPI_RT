package br.com.rafaelabreu.projetoCadastro.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rafaelabreu.projetoCadastro.entities.Usuario;
import br.com.rafaelabreu.projetoCadastro.repositories.UsuarioRepository;
import br.com.rafaelabreu.projetoCadastro.services.UsuarioService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	@Autowired
	private UsuarioRepository repository;
	
	private final PasswordEncoder encoder;

	public UsuarioResource(UsuarioService service, UsuarioRepository repository, PasswordEncoder encoder) {
		this.service = service;
		this.repository = repository;
		this.encoder = encoder;
	}

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario) {
		Usuario obj = service.save(usuario);
		return ResponseEntity.ok().body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/validarSenha")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String login, @RequestParam String senha) {

        Optional<Usuario> optUsuario = repository.findByLogin(login);
        if (optUsuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        Usuario usuario = optUsuario.get();
        boolean valid = encoder.matches(senha, usuario.getSenha());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);

    }

}
