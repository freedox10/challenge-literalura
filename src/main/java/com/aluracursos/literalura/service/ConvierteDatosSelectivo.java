package com.aluracursos.literalura.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ConvierteDatosSelectivo implements IConvierteDatosSelectivo {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> List<T> obtenerDatosSelectivo2(String json) {
        try {
            JsonNode rootNode = mapper.readTree(json);
            //System.out.println("Arbol: " + rootNode);

            JsonNode resultsNode = rootNode.get("results");
            //System.out.println("Nodo results: " + resultsNode);
            System.out.println("Nodo results.toString: " + resultsNode.toString());
            return mapper.

            return mapper.readValue(resultsNode.toString(), new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        //return List.of();
    }
}
