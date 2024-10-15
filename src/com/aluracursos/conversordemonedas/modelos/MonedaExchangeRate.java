package com.aluracursos.conversordemonedas.modelos;

import java.util.Map;

public record MonedaExchangeRate(String base_code, Map conversion_rates) {
}
