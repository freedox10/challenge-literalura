package com.aluracursos.literalura.service;

import com.aluracursos.literalura.model.DatosLibro;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ConvierteDatosSelectivo {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<DatosLibro> obtenerDatosLibros(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(json);
            //System.out.println("Arbol: " + rootNode);

            JsonNode resultsNode = rootNode.get("results");
            //System.out.println("Nodo results: " + resultsNode);

            return mapper.readValue(resultsNode.toString(), new TypeReference<List<DatosLibro>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
