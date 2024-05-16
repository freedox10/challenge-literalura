package com.aluracursos.literalura.model;

import java.util.List;

public class Resultados {

    private Double cantidad;
    private String proximo;
    private String anterior;
    private String resultados;

    public Resultados(DatosResultados datosResultados) {
        this.cantidad = datosResultados.cantidad();
        this.proximo = datosResultados.proximo();
        this.anterior = datosResultados.anterior();
        this.resultados = datosResultados.resultados();
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
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

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }
}
