package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("id") Integer idGutemberg,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<Autor> autores,
        @JsonAlias("languages") List<String> idiomas,
        @JsonAlias("download_count") Integer cantidadBajadas
) {
}

//public record DatosLibro(
//        @JsonAlias("id") Double idGutemberg,
//        @JsonAlias("title") String titulo,
//        @JsonAlias("authors") List<Autor> autores,
//        @JsonAlias("translators") List<Traductores> traductores,
//        @JsonAlias("subjects") List<Asignatura>asignaturas,
//        @JsonAlias("bookshelves") List<Estanterias> estanterias,
//        @JsonAlias("languages") List<Idiomas> idiomas,
//        @JsonAlias("copyright") String copyright,
//        @JsonAlias("media_type") String tipoDeMedio,
//        @JsonAlias("formats") List<Formatos> formatos,
//        @JsonAlias("download_count") Double cantidadBajadas
//) {
//}
