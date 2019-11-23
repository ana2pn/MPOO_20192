package com.example.pizza.pizza.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.pizza.infra.persistencia.DBHelper;
import com.example.pizza.pizza.dominio.Pizza;

import static com.example.pizza.infra.persistencia.DBHelper.TABELA_PIZZA;

public class PizzaDAO {
    private DBHelper dbHelper;


    public PizzaDAO(Context context) {
        dbHelper = new DBHelper(context);
    }
    public long cadastrar(Pizza pizza){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.COL_NOME_PIZZA, pizza.getNome());
        values.put(DBHelper.COL_CODIGO_PIZZA, pizza.getCodigo());
        values.put(DBHelper.COL_DESCRICAO_PIZZA, pizza.getDescricao());


        long id = db.insert(TABELA_PIZZA, null, values);
        db.close();
        return id;

    }
    public void consultar(){

    }
}
