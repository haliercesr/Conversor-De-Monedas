package com.aluracursos.conversordemonedas.calculos;

import com.aluracursos.conversordemonedas.modelos.Moneda;

public class ConversionDeDivisa {

    public double calculos(Moneda miMoneda, String divisaConvertir, double Monto) {
        Double tasaConversion = (Double) miMoneda.getConversionRates().get(divisaConvertir);
        double montoConvertido = Monto * tasaConversion;
        return montoConvertido;
    }
}
