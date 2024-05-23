package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosResultados(
        @JsonAlias("count") Integer cantidad,
        @JsonAlias("next") String proximo,
        @JsonAlias("previous") String anterior,
        @JsonAlias("results") List<DatosLibro> resultados
) {
}
