package com.aluracursos.literalura.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, String nodo, Class<T> clase);
}
