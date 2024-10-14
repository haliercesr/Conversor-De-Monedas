package com.aluracursos.conversordemonedas.network;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Httpclient {
    public static void main(String[] args) {

        String direccion = "https://v6.exchangerate-api.com/v6/8b595c6071e8dee5aef745d0/latest/USD";

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);


        } catch (RuntimeException | IOException | InterruptedException e) {
            System.out.println("Ocurrio un error: ");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finalizado!");
        }
    }
}
