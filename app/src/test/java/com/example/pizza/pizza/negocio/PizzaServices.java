package com.example.pizza.pizza.negocio;

import android.content.Context;

import com.example.pizza.pizza.dominio.Pizza;
import com.example.pizza.pizza.persistencia.PizzaDAO;

public class PizzaServices {
    private PizzaDAO dao;

    public PizzaServices(Context context) {
        return  dao = new PizzaDAO(context);
    }

    public long cadastrar(Pizza pizza) throws Exception {
        Pizza pizzaDB = dao.consultar(pizza.getCodigo());
        if (pizzaDB != null) {
            throw new Exception("Email já cadastrado.");
        }
//        return dao.cadastrar(pizza);

    }


