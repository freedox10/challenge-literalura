package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Autor {

    @JsonProperty("name")
    private String nombre;
    @JsonProperty("birth_year")
    private String anoNacimiento;
    @JsonProperty("death_year")
    private String anoMuerte;

    public Autor(){}

    public Autor(String nombre, String anoNacimiento, String anoMuerte) {
        this.nombre = nombre;
        this.anoNacimiento = anoNacimiento;
        this.anoMuerte = anoMuerte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnoNacimiento() {
        return anoNacimiento;
    }

    public void setAnoNacimiento(String anoNacimiento) {
        this.anoNacimiento = anoNacimiento;
    }

    public String getAnoMuerte() {
        return anoMuerte;
    }

    public void setAnoMuerte(String anoMuerte) {
        this.anoMuerte = anoMuerte;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", anoNacimiento='" + anoNacimiento + '\'' +
                ", anoMuerte='" + anoMuerte + '\'' +
                '}';
    }
}
