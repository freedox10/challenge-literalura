package com.aluracursos.literalura.model;


import java.util.List;

public class Resultados {

    private Integer cantidad;
    private String proximo;
    private String anterior;
    private List<DatosLibro> resultados;


    public Resultados() {
    }

    public Resultados(Integer cantidad, String proximo, String anterior, List<DatosLibro> resultados) {
        this.cantidad = cantidad;
        this.proximo = proximo;
        this.anterior = anterior;
        this.resultados = resultados;
    }

    public Resultados(DatosResultados datosResultados) {
        this.cantidad = datosResultados.cantidad();
        this.proximo = datosResultados.proximo();
        this.anterior = datosResultados.anterior();
        this.resultados = datosResultados.resultados();
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getProximo() {
        return proximo;
    }

    public void setProximo(String proximo) {
        this.proximo = proximo;
    }

    public String getAnterior() {
        return anterior;
    }

    public void setAnterior(String anterior) {
        this.anterior = anterior;
    }

    public List<DatosLibro> getResultados() {
        return resultados;
    }

    public void setResultados(List<DatosLibro> resultados) {
        this.resultados = resultados;
    }


    @Override
    public String toString() {
        return  "coinciden " + cantidad + " libros" +
                ", proximo: " + proximo +
                ", anterior: " + anterior;
    }
}
