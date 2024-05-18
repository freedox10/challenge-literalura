package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
        @JsonProperty("name") String nombre,
        @JsonProperty("birth_year") Integer anoNacimiento,
        @JsonProperty("death_year") Integer anoMuerte
) {
}
