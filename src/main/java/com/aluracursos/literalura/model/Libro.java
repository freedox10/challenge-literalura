package com.aluracursos.literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer idGut;
    private String titulo;
    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autores;
    private List<String> idiomas;
    private Integer cantidadBajadas;

    public Libro() {
    }

    public Libro(Integer idGut, String titulo, List<Autor> autores, List<String> idiomas, Integer cantidadBajadas) {
        this.idGut = idGut;
        this.titulo = titulo;
        this.autores = autores;
        this.idiomas = idiomas;
        this.cantidadBajadas = cantidadBajadas;
    }

    public Libro(DatosLibro datosLibro) {
        this.idGut = datosLibro.idGut();
        this.titulo = datosLibro.titulo();
        this.autores = datosLibro.autores();
        this.idiomas = datosLibro.idiomas();
        this.cantidadBajadas = datosLibro.cantidadBajadas();
    }

    public Libro(Integer idGut, String titulo, List<String> idiomas, Integer cantidadBajadas) {
        this.idGut = idGut;
        this.titulo = titulo;
        this.idiomas = idiomas;
        this.cantidadBajadas = cantidadBajadas;
    }

    public Integer getIdGut() { return idGut; }

    public void setIdGut(Integer idGut) {
        this.idGut = idGut;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public void agregarAutor(Autor autor) {
        this.autores.add(autor);
    } //Setter modificado para adherir autor a autores.

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getCantidadBajadas() {
        return cantidadBajadas;
    }

    public void setCantidadBajadas(Integer cantidadBajadas) {
        this.cantidadBajadas = cantidadBajadas;
    }

    @Override
    public String toString() {
        return  ">IdGut:" + idGut +
                "< *" + titulo +
                "* autores: " + autores +
                ", idiomas: " + idiomas +
                ", bajadas: " + cantidadBajadas;
    }
}
