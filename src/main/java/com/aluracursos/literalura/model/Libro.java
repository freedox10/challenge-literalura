package com.aluracursos.literalura.model;

import java.util.List;

public class Libro {

    private Double idGutemberg;
    private String titulo;
    private List<Asignatura> asignaturas;
    private List<Autor> autores;
    private List<Traductores> traductores;
    private List<Estanterias> estanterias;
    private List<Idiomas> idiomas;
    private String copyright;
    private String tipoDeMedio;
    private List<Formatos> formatos;
    private Double cantidadBajadas;

    public Libro(DatosLibro datosLibro) {
        this.idGutemberg = datosLibro.idGutemberg();
        this.titulo = datosLibro.titulo();
        this.asignaturas = datosLibro.asignaturas();
        this.autores = datosLibro.autores();
        this.traductores = datosLibro.traductores();
        this.estanterias = datosLibro.estanterias();
        this.idiomas = datosLibro.idiomas();
        this.copyright = datosLibro.copyright();
        this.tipoDeMedio = datosLibro.tipoDeMedio();
        this.formatos = datosLibro.formatos();
        this.cantidadBajadas = datosLibro.cantidadBajadas();
    }

    public Double getIdGutemberg() {
        return idGutemberg;
    }

    public void setIdGutemberg(Double idGutemberg) {
        this.idGutemberg = idGutemberg;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Traductores> getTraductores() {
        return traductores;
    }

    public void setTraductores(List<Traductores> traductores) {
        this.traductores = traductores;
    }

    public List<Estanterias> getEstanterias() {
        return estanterias;
    }

    public void setEstanterias(List<Estanterias> estanterias) {
        this.estanterias = estanterias;
    }

    public List<Idiomas> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idiomas> idiomas) {
        this.idiomas = idiomas;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getTipoDeMedio() {
        return tipoDeMedio;
    }

    public void setTipoDeMedio(String tipoDeMedio) {
        this.tipoDeMedio = tipoDeMedio;
    }

    public List<Formatos> getFormatos() {
        return formatos;
    }

    public void setFormatos(List<Formatos> formatos) {
        this.formatos = formatos;
    }

    public Double getCantidadBajadas() {
        return cantidadBajadas;
    }

    public void setCantidadBajadas(Double cantidadBajadas) {
        this.cantidadBajadas = cantidadBajadas;
    }
}
