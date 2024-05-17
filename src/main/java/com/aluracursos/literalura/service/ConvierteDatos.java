package com.aluracursos.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, String nodo, Class<T> clase) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (nodo.isEmpty()){
                return mapper.readValue(json,clase);
            } else {
                JsonNode rootNode = mapper.readTree(json);
                JsonNode resultsNode = rootNode.get(nodo);
                return mapper.readValue(resultsNode.toString(),clase);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
