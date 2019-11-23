
package com.example.pizza.pizza.negocio;

import android.content.ContentValues;
import android.content.Context;
import android.widget.EditText;

import com.example.pizza.pizza.dominio.Pizza;
import com.example.pizza.pizza.persistencia.PizzaDAO;

public class PizzaServices {
    private PizzaDAO dao;

    public PizzaServices(Context context) {
        dao = new PizzaDAO(context);
    }

    public long cadastrar(Pizza pizza) throws Exception {
        Pizza pizzaDB = dao.consultarCodigo(pizza.getCodigo());
        if (pizzaDB != null) {
            throw new Exception("Pizza já cadastrada.");
        }
        return dao.cadastrar(pizza);

    }

    public void logar(String nome, String codigo) throws Exception {
        Pizza usuario = dao.consultar(nome, codigo);
        if (usuario == null) {
            SessaoPizza.Logado = null;
            throw new Exception("Usuário/senha inválidos.");
        }
    }
}
