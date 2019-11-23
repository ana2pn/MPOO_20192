package com.example.pizza.pizza.negocio;

import com.example.pizza.pizza.dominio.Pizza;

import java.util.Date;

public class SessaoPizza {
    public static Pizza Logado;
    public static Date horaLogin;

    public static Pizza getPizza() {
        return Logado;
    }

    public static void reset() {
        Logado = null;
        horaLogin = null;
    }
}
