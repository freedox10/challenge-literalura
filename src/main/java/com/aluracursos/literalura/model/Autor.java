package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

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
    
    @ManyToMany(mappedBy = "autores", fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor(){}

    public Autor(String nombre, Integer anioNacimiento, Integer anioMuerte) {
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
        this.anioMuerte = anioMuerte;
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
        return "Autor: " + nombre +
                ", Año Nacimiento: " + anioNacimiento +
                ", Año Muerte: " + anioMuerte;
    }
}
