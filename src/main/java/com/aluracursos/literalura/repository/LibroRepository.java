package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query("SELECT l FROM Libro l JOIN l.idGut idgut WHERE idgut LIKE :idGutengerg")
    List<Libro> buscarLibroPorIdGut(@Param("idGutengerg") Integer idGutengerg);

}
