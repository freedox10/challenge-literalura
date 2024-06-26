package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("name")
    private String nombre;
    @JsonProperty("birth_year")
    private Integer anioNacimiento;
    @JsonProperty("death_year")
    private Integer anioMuerte;
    @ManyToOne
    private Libro libro;

    public Autor(){}

    public Autor(String nombre, Integer anioNacimiento, Integer anioMuerte) {
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
        this.anioMuerte = anioMuerte;
    }

    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.anioNacimiento = datosAutor.anioNacimiento();
        this.anioMuerte = datosAutor.anioMuerte();
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getanioNacimiento() {
        return anioNacimiento;
    }

    public void setanioNacimiento(Integer anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public Integer getanioMuerte() {
        return anioMuerte;
    }

    public void setanioMuerte(Integer anioMuerte) {
        this.anioMuerte = anioMuerte;
    }

    @Override
    public String toString() {
        return "Autor: " + nombre + ", " + anioNacimiento + " - " + anioMuerte + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(nombre, autor.nombre) && Objects.equals(anioNacimiento, autor.anioNacimiento) && Objects.equals(anioMuerte, autor.anioMuerte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, anioNacimiento, anioMuerte);
    }
}
