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
    private String anioNacimiento;
    
    @JsonProperty("death_year")
    private String anioMuerte;
    
    @ManyToMany(mappedBy = "autores", fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor(){}

    public Autor(String nombre, String anioNacimiento, String anioMuerte) {
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

    public String getanioNacimiento() {
        return anioNacimiento;
    }

    public void setanioNacimiento(String anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public String getanioMuerte() {
        return anioMuerte;
    }

    public void setanioMuerte(String anioMuerte) {
        this.anioMuerte = anioMuerte;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", anioNacimiento='" + anioNacimiento + '\'' +
                ", anioMuerte='" + anioMuerte + '\'' +
                '}';
    }
}
