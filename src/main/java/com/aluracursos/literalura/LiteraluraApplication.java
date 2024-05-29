package com.aluracursos.literalura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aluracursos.literalura.principal.Principal;
import com.aluracursos.literalura.service.OperarDB;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private OperarDB servicio = new OperarDB();

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Instanciar un objeto Principal
		Principal principal = new Principal(servicio);
		principal.muestraElMenu();

	}
}
