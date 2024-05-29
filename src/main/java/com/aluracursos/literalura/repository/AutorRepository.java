package com.aluracursos.literalura.repository;

import com.aluracursos.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a from Autor a WHERE a.nombre LIKE :nombreB% AND a.anioNacimiento = :anioNacimientoB AND a.anioMuerte = :anioMuerteB")
    Autor buscarAutor(String nombreB, Integer anioNacimientoB, Integer anioMuerteB);

}
