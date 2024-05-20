package com.aluracursos.literalura.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ConvierteDatosSelectivo2 implements IConvierteDatosSelectivo2{
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> List<T> obtenerDatosSelectivo2(String json) {
        try {
            JsonNode rootNode = mapper.readTree(json);
            //System.out.println("Arbol: " + rootNode);

            JsonNode resultsNode = rootNode.get("results");
            //System.out.println("Nodo results: " + resultsNode);

            return mapper.readValue(resultsNode.toString(), new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        //return List.of();
    }
}
