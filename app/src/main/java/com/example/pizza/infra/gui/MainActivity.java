package com.example.pizza.infra.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pizza.R;
import com.example.pizza.pizza.gui.CadastroPizza;
import com.example.pizza.pizza.gui.HomePizza;
import com.example.pizza.pizza.negocio.PizzaServices;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        final EditText nome = findViewById(R.id.nomeTextField);
        final EditText codigo = findViewById(R.id.codigoTextField);

        Button btnCadastrar = findViewById(R.id.btnCadastrar);
        Button btnLogin = findViewById(R.id.btnLogin);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CadastroPizza.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrarPizza(nome, codigo);
            }
        });
    }
        private void entrarPizza(EditText nome, EditText codigo) {
            PizzaServices services = new PizzaServices(getBaseContext());
            Validacao validacao = new Validacao();
            if (validacao.isValido(nome,codigo)){
                String Snome = nome.getText().toString().trim();
                String Scodigo = codigo.getText().toString().trim();
                try {
                    services.logar(Snome,Scodigo);
                    finish();
                    startActivity(new Intent(MainActivity.this, HomePizza.class));

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Pizza/codigo incorretos.", Toast.LENGTH_LONG).show();
                }
            }
    }
}


