package com.aluracursos.literalura.service;

import com.aluracursos.literalura.model.Libro;
import com.aluracursos.literalura.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RequiredArgsConstructor
public class OperarEnDB {

    @Autowired
    private LibroRepository repoLibro;

    public OperarEnDB(LibroRepository repoLibro) {
        this.repoLibro = repoLibro;
    }

    public List<Libro> mostrarLibros(){
        return repoLibro.findAll();
    }
}
