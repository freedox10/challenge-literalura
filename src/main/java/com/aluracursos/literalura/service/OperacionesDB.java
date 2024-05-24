package com.aluracursos.literalura.service;

import com.aluracursos.literalura.model.Autor;
import com.aluracursos.literalura.model.Libro;
import com.aluracursos.literalura.repository.AutorRepository;
import com.aluracursos.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OperacionesDB {
    @Autowired
    private AutorRepository repositorioAutor;
    @Autowired
    private LibroRepository repositorioLibro;

    public OperacionesDB(AutorRepository repositorioAutor, LibroRepository repositorioLibro) {
        this.repositorioAutor = repositorioAutor;
        this.repositorioLibro = repositorioLibro;
    }

    private void registrarLibro(Libro libroSeleccionado){
        var prueba = libroSeleccionado.getIdGut();
        List<Libro> libroEnDB = repositorioLibro.buscarLibroPorIdGut(prueba);

        if (libroEnDB.isEmpty()){
            List<Autor> autoresVerificados = verificarAutores(libroSeleccionado.getAutores());

            for (Autor autor : autoresVerificados){

            }

            repositorioLibro.save(libroSeleccionado);
        } else {
            System.out.println("> El Libro ya se encuentra registrado <");
        }

        //repositorioAutor.save(autorSeleccionado);

    }

    public List<Autor> verificarAutores(List<Autor> entradaAutores){
        List<Autor> salidaAutores = new ArrayList<>();
        for (Autor autor : entradaAutores){
            Autor autorEnDB = repositorioAutor.buscarAutor(autor.getNombre(), autor.getanioNacimiento(), autor.getanioMuerte());
            if (autorEnDB == null) {
                salidaAutores.add(new Autor(autor.getNombre(), autor.getanioNacimiento(), autor.getanioMuerte()));
            } else {
                salidaAutores.add(autorEnDB);
            }
        }
        return salidaAutores;
    }

}
