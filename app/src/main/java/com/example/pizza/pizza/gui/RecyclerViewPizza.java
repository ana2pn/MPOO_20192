package com.example.pizza.pizza.gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;

import com.example.pizza.R;
import com.example.pizza.pizza.dominio.Pizza;
import com.example.pizza.pizza.persistencia.PizzaDAO;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewPizza extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ArrayList<String> nome = new ArrayList<>();
    private ArrayList<String> codigo = new ArrayList<>();
    private ArrayList<String> descricao = new ArrayList<>();
    private List<Pizza> pizzas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_pizza);
        getSupportActionBar().hide();
        initServicos();

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void initServicos() {
        PizzaDAO dao = new PizzaDAO(getApplicationContext());
        pizzas = dao.getAllPizzas();

        for (int i = 0; i < pizzas.size(); i++) {
            nome.add(pizzas.get(i).getNome());
            codigo.add(pizzas.get(i).getCodigo());
            descricao.add(pizzas.get(i).getDescricao());

        }
        initRecyclerView();

    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.pizzarecylcer);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, nome, codigo, descricao );
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
