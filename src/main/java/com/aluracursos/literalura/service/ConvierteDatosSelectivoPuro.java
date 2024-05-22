package com.aluracursos.literalura.service;

import com.aluracursos.literalura.model.DatosLibro;
import com.aluracursos.literalura.model.Libro;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ConvierteDatosSelectivoPuro {
    private final ObjectMapper mapper = new ObjectMapper();

    public List<DatosLibro> obtenerDatosSelectivoPuro(String json, String nodo) {
        try {
            JsonNode rootNode = mapper.readTree(json);
            //System.out.println("Arbol: " + rootNode);

            JsonNode resultsNode = rootNode.get(nodo);
            //System.out.println("Nodo results: " + resultsNode);
            //System.out.println("Nodo results.toString: " + resultsNode.toString());

            return mapper.readValue(resultsNode.toString(), new TypeReference<List<DatosLibro>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

    }

    public List<Libro> convierteListaDLaListaL(List<DatosLibro> listaDatosLibro){
        return listaDatosLibro.stream()
                .map(l->new Libro(l.idGut(), l.titulo(), l.autores(), l.idiomas(), l.cantidadBajadas()))
                .collect(Collectors.toList());
    }

}
