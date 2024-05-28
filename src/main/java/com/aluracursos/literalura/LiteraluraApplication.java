package com.aluracursos.literalura;

import com.aluracursos.literalura.principal.BuscarResultadosAPI;
import com.aluracursos.literalura.principal.Principal;
import com.aluracursos.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository libroRepository;
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Instanciar un objeto Principal
		Principal principal = new Principal(libroRepository);
		principal.muestraElMenu();

	}
}
