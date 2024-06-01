package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a")
    List<Autor> buscarAutor();

    @Query("SELECT a FROM Autor a WHERE a.anioMuerte >= :anio AND a.anioNacimiento <= :anio")
    List<Autor> encontrarAutoresVivos(int anio);

}
