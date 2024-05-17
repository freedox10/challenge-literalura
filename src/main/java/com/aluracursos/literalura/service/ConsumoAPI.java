package com.aluracursos.literalura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    public String obtenerDatosAPI(String url){
        //System.out.println("Llamado: " + url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e)  {
            throw new RuntimeException(e);
        }
        String json = response.body();
        if (json == null || json.isEmpty()){
            throw new IllegalArgumentException("Respuesta API nula o vacía");
        }
        //System.out.println("Body Json: " +json);
        return json;
    }
}
