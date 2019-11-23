package com.example.pizza.infra.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "AppPizza.bd";
    private static final int DB_VERSION = 1;

    public static final String TABELA_PIZZA = "Tabela_Pizza";
    public static final String COL_ID_PIZZA = "id";
    public static final String COL_NOME_PIZZA = "nome";
    public static final String COL_CODIGO_PIZZA = "codigo";
    public static final String COL_DESCRICAO_PIZZA = "descricao";

    private static final String SQL_CREATE_TABLE = " CREATE TABLE %1$s ";
    private static final String SQL_INTEGER_AUTOINCREMENT = " %2$s INTEGER PRIMARY KEY AUTOINCREMENT, ";
    //private static final String[] TABELAS = {TABELA_PIZZA};


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTablePizza(db);
    }

    public void createTablePizza(SQLiteDatabase db){
        String sqlTbPizza = SQL_CREATE_TABLE + "(" +
                SQL_INTEGER_AUTOINCREMENT +
                " %3$s TEXT NOT NULL, " +
                " %4$s TEXT NOT NULL, " +
                " %5$s TEXT NOT NULL " +
                ");";
        sqlTbPizza = String.format(sqlTbPizza,TABELA_PIZZA, COL_ID_PIZZA, COL_NOME_PIZZA,COL_CODIGO_PIZZA
                ,COL_DESCRICAO_PIZZA);
        db.execSQL(sqlTbPizza);

    }

    public void dropTables(SQLiteDatabase db){
        String dropSql = "DROP TABLE IF EXISTS %1$s;";
        db.execSQL(String.format(dropSql,TABELA_PIZZA));

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        dropTables(db);
        onCreate(db);
    }
}
