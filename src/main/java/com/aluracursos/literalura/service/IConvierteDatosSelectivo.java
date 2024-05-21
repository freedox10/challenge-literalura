package com.aluracursos.literalura.service;

import java.util.List;

public interface IConvierteDatosSelectivo {
    <T> List<T> obtenerDatosSelectivo(String json);
}
