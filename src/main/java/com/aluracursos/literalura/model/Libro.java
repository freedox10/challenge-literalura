package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Libro {
    @JsonProperty("id")
    private Integer idGut;
    @JsonProperty("title")
    private String titulo;
    @JsonProperty("authors")
    private List<Autor> autores;
    @JsonProperty("languages")
    private List<String> idiomas;
    @JsonProperty("download_count")
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

    public Integer getIdGutemberg() {
        return idGut;
    }

    public void setIdGutemberg(Integer idGut) {
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
        return  "IdGut: " + idGut +
                " - " + titulo +
                ", autores: " + autores +
                ", idiomas: " + idiomas +
                ", bajadas: " + cantidadBajadas;
    }
}
