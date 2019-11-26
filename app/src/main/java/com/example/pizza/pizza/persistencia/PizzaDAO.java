package com.example.pizza.pizza.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pizza.infra.persistencia.DBHelper;
import com.example.pizza.pizza.dominio.Pizza;

import java.util.ArrayList;
import java.util.List;

import static com.example.pizza.infra.persistencia.DBHelper.COL_CODIGO_PIZZA;
import static com.example.pizza.infra.persistencia.DBHelper.COL_NOME_PIZZA;
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
    public Pizza consultar(String nome, String codigo){
        Pizza result = null;
        String query =
                " SELECT * " +
                        " FROM " + TABELA_PIZZA +
                        " WHERE " + COL_NOME_PIZZA + " = ? " +
                        " AND " + COL_CODIGO_PIZZA + " = ? ";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new String[]{nome,codigo});
        if (cursor.moveToFirst()){
            result = criarPizza(cursor);
        }
        return result;
    }
    private Pizza criarPizza(Cursor cursor) {
        Pizza result = new Pizza();
        result.setId(cursor.getInt(0));
        result.setNome(cursor.getString(1));
        result.setCodigo(cursor.getString(2));
        result.setDescricao(cursor.getString(3));

        return result;
    }
    public Pizza consultarCodigo (String codigo){
        Pizza result = null;
        String query =
                " SELECT * " +
                        " FROM " + TABELA_PIZZA +
                        " WHERE " + COL_CODIGO_PIZZA+ " = ? ";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, new String[]{codigo});
        if (cursor.moveToFirst()) {
            result = criarPizza(cursor);
        }
        return result;
    }

    public List<Pizza> getAllPizzas() {
        List<Pizza> pizzasArrayList = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query = " SELECT * " +
                " FROM " + TABELA_PIZZA;
        String[] args = {};
        Cursor cursor = db.rawQuery(query, args);
        Pizza pizza = null;
        if (cursor.moveToFirst()) {
            do {
                pizza = criarPizza(cursor);
                pizzasArrayList.add(pizza);
            } while (cursor.moveToNext());

            cursor.close();
            db.close();
            return pizzasArrayList;
        }
        cursor.close();
        db.close();
        return pizzasArrayList;
    }
}

