package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.calculos.ConversionDeDivisa;
import com.aluracursos.conversordemonedas.modelos.Moneda;
import com.aluracursos.conversordemonedas.modelos.MonedaExchangeRate;
import com.aluracursos.conversordemonedas.network.Httpclient;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Scanner;

public class principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        String divisaBase = "";
        int opcionElegida = 0;
        String divisaConvertir = "";
        Httpclient servidor = new Httpclient();
        ConversionDeDivisa miCalculadora = new ConversionDeDivisa();
        Gson gson = new Gson();

        var menu = """
                *********************************************
                Bienvenido al conversor de monedas
                
                1) Dolar =>> Peso Argentino
                2) Peso Argentino =>> Dolar
                3) Dolar =>> Real Brasileño
                4) Real Brasileño =>> Dolar
                5) Dolar ==> Peso Colombiano
                6) Peso Colombiano =>> Dolar
                7) Salir
                
                Elija una opcion valida:
                
                *********************************************
                """;

        while (opcionElegida != 7) {
            System.out.println(menu);
            opcionElegida = lectura.nextInt();

            switch (opcionElegida) {
                case 1:
                    divisaBase = "USD";
                    divisaConvertir = "ARS";
                    break;
                case 2:
                    divisaBase = "ARS";
                    divisaConvertir = "USD";
                    break;
                case 3:
                    divisaBase = "USD";
                    divisaConvertir = "BRL";
                    break;
                case 4:
                    divisaBase = "BRL";
                    divisaConvertir = "USD";
                    break;
                case 5:
                    divisaBase = "USD";
                    divisaConvertir = "COP";
                    break;
                case 6:
                    divisaBase = "COP";
                    divisaConvertir = "USD";
                    break;
                case 7:
                    System.out.println("Hasta luegoo!!");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            if (opcionElegida == 7) break;
            if (opcionElegida > 7 || opcionElegida < 0) continue;

            try {
                String json = servidor.getCotizacion(divisaBase);
                MonedaExchangeRate miMonedaExchangeRate = gson.fromJson(json, MonedaExchangeRate.class);
                Moneda miMoneda = new Moneda(miMonedaExchangeRate);

                System.out.println("Ingrese el valor que deseas convertir: ");
                var montoParaConvertir = lectura.nextDouble();
                double valor = miCalculadora.calculos(miMoneda, divisaConvertir, montoParaConvertir);
                System.out.println("El valor de " + montoParaConvertir + " [" + divisaBase + "] es de " + valor + " [" + divisaConvertir + "]");
            } catch (RuntimeException e) {
                System.out.println("Ocurrio un error: ");
                System.out.println(e.getMessage());
            }

        }
    }
}
