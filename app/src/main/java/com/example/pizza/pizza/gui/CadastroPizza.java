package com.example.pizza.pizza.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pizza.R;
import com.example.pizza.infra.gui.MainActivity;

public class CadastroPizza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pizza);
        getSupportActionBar().hide();

        EditText nome = findViewById(R.id.nomeCadastroTextField);
        EditText codigo = findViewById(R.id.codigoCadastroTextField);
        EditText descricao = findViewById(R.id.descricaoCadastroTextField);


    }
}
