package com.aluracursos.conversordemonedas.network;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Httpclient {
    private String code;
    private String cotizacion;
    private String url;

    public Httpclient() throws IOException, InterruptedException {
        this.url = "https://v6.exchangerate-api.com/v6/8b595c6071e8dee5aef745d0/latest/";
    }

    public String getCotizacion(String code) throws IOException, InterruptedException {
        this.code = code;
        String direccion = url + code;

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        this.cotizacion = json;
        return json;
    }


}

