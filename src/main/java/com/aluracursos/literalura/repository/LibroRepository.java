package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query("SELECT l FROM Libro l WHERE l.idGut = :idGutB%")
    Libro buscarLibroPorIdGut(Integer idGutB);

    @Query("SELECT p FROM Libro p WHERE array_contains(p.idiomas, :idiomaBuscado)")
    Collection<Libro> findAllByIdiomasContaining(@Param("idiomaBuscado") String idiomaBuscado);

    @Query("SELECT b FROM Libro b ORDER BY b.cantidadBajadas DESC LIMIT 10")
    List<Libro> buscarTop10Libros();

}
