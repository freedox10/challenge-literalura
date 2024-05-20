package com.aluracursos.literalura.model;

import java.util.List;

public class ContenedorResultados {
    Resultados inicial;
    List<Libro> paginado;

    public ContenedorResultados() {
    }

    public ContenedorResultados(Resultados inicial, List<Libro> paginado) {
        this.inicial = inicial;
        this.paginado = paginado;
    }

    public Resultados getInicial() {
        return inicial;
    }

    public void setInicial(Resultados inicial) {
        this.inicial = inicial;
    }

    public List<Libro> getPaginado() {
        return paginado;
    }

    public void setPaginado(List<Libro> paginado) {
        this.paginado = paginado;
    }

    @Override
    public String toString() {
        return paginado.toString();
    }
}
