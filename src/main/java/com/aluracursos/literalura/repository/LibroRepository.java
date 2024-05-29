package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.model.Autor;
import com.aluracursos.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query("SELECT l FROM Libro l WHERE l.idGut = :idGutB%")
    Libro buscarLibroPorIdGut(Integer idGutB);

//    @Query("SELECT a FROM Libro b JOIN b.idiomas a WHERE a = :idioma")
//    //@Query("SELECT DISTINCT b FROM Libro b JOIN b.idiomas l WHERE :idioma IN (l)")
//    List<Libro> encontrarLibroPorIdioma(String idioma);

    @Query("SELECT l FROM Libro l JOIN l.idiomas idio WHERE idio = :idioma")
    List<Libro> buscarLibrosPorIdioma(@Param("idioma") String idioma);

}
