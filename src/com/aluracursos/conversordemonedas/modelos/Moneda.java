package com.aluracursos.conversordemonedas.modelos;

import java.util.Map;

public class Moneda {
    private String baseCode;
    private Map conversionRates;

    public Moneda(MonedaExchangeRate miMonedaExchangeRate) {
        this.baseCode = miMonedaExchangeRate.base_code();
        Map<String, Double> conversionRatesMap = miMonedaExchangeRate.conversion_rates();
        this.conversionRates = conversionRatesMap;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public Map getConversionRates() {
        return conversionRates;
    }

    public void setConversionRates(Map conversionRates) {
        this.conversionRates = conversionRates;
    }
}
