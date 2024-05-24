package com.aluracursos.literalura.service;

import com.aluracursos.literalura.model.Libro;
import com.aluracursos.literalura.repository.AutorRepository;
import com.aluracursos.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;

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

    public OperacionesDB(AutorRepository repositorioAutor) {
        this.repositorioAutor = repositorioAutor;
    }

    public OperacionesDB(LibroRepository repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public OperacionesDB() {

    }


    public void registrarLibro(Libro libroSeleccionado){
        Optional<Libro> libroEnDB = repositorioLibro.findByIdGutContains(libroSeleccionado.getIdGut());
        System.out.println("libroEnDB"+libroEnDB);
    }

}
