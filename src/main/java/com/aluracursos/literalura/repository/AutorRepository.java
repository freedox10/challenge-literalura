package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a WHERE a.name LIKE :nombre% AND a.yearBirth = :anioNacimiento AND a.yearDeath = :anioMuerte")
    Autor buscarAutor(String nombre, Integer anioNacimiento, Integer anioMuerte);

}
