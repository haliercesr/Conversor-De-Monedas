package com.aluracursos.conversordemonedas.principal;

import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        var menu="""
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

        while(true) {
            System.out.println(menu);
            var opcionElegida = lectura.nextInt();
            if (opcionElegida == 7) {
                break;
            }
            if (opcionElegida<0 || opcionElegida>7) {
                System.out.println("Opcion no valida");
            }
            System.out.println("Ingrese el valor que deseas convertir: ");
            var montoParaConvertir = lectura.nextDouble();
            System.out.println("El valor de "+montoParaConvertir+" es de "+25);


        }
    }
}
