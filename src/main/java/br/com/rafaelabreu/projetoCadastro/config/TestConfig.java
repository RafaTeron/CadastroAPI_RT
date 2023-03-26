package br.com.rafaelabreu.projetoCadastro.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.rafaelabreu.projetoCadastro.entities.Usuario;
import br.com.rafaelabreu.projetoCadastro.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private UsuarioRepository usuariorepository;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario usu1 = new Usuario(null, "Teron1","Rafael", "dd444555", "teron@gmail.com", "Masculino", "222.448.222-22", "22222-222", 888888888, sdf.parse("15/01/1996"));
		Usuario usu2 = new Usuario(null, "Tata22","Thayna", "ttpp4555", "tata@gmail.com", "Feminino", "111.111.111-22", "11111-222", 111111111, sdf.parse("11/11/1111"));
		
		usuariorepository.saveAll(Arrays.asList(usu1,usu2));
	}

}
