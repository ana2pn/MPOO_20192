package com.example.pizza.pizza.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pizza.R;
import com.example.pizza.infra.gui.MainActivity;
import com.example.pizza.infra.gui.Validacao;
import com.example.pizza.pizza.dominio.Pizza;

public class CadastroPizza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pizza);
        getSupportActionBar().hide();

        Button btncadastrar = findViewById(R.id.btnCadastrar);



        btncadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrar();
            }
        });

    }

    private void cadastrar() {
        if (validarCampos()) {
            Pizza pizza = criarPizza();

            //PizzaServices services = new PizzaServices(getBaseContext());
            //services.cadastrar(pizza);
            Toast.makeText(getApplicationContext(), "Pizza cadastrada com sucesso.", Toast.LENGTH_LONG).show();
            startActivity(new Intent(CadastroPizza.this, MainActivity.class));
        }
    }

    private boolean validarCampos() {
        EditText nome = findViewById(R.id.nomeCadastroTextField);
        EditText codigo = findViewById(R.id.codigoCadastroTextField);
        EditText descricao = findViewById(R.id.descricaoCadastroTextField);

        Validacao valido = new Validacao();
        boolean nomeValido =
                valido.isValido(nome);
        boolean codigoValido =
                valido.isValido(codigo);
        boolean descricaoValida =
                valido.isValido(descricao);
        return nomeValido && codigoValido && descricaoValida;
    }

    private Pizza criarPizza(){
        EditText nome = findViewById(R.id.nomeCadastroTextField);
        EditText codigo = findViewById(R.id.codigoCadastroTextField);
        EditText descricao = findViewById(R.id.descricaoCadastroTextField);

        Pizza result = new Pizza();
        result.setNome(nome.getText().toString().trim());
        result.setCodigo(codigo.getText().toString().trim());
        result.setDescricao(descricao.getText().toString().trim());
        return result;
    }
}
