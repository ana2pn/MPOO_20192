package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InformacoesPizza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes_pizza);
        getSupportActionBar().hide();
        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if (getIntent().hasExtra("nome") && getIntent().hasExtra("codigo") && getIntent().hasExtra("descricao")){
            String nome = getIntent().getStringExtra("nome");
            String codigo = getIntent().getStringExtra("codigo");
            String descricao = getIntent().getStringExtra("descricao");

            setDadosTela(nome, codigo, descricao);
        }
    }
    private void setDadosTela(String nome, String codigo, String descricao){
        TextView nomeTela = findViewById(R.id.nomeInformacoes);
        TextView codigoTela = findViewById(R.id.codigoInformacoes);
        TextView descricaoTela = findViewById(R.id.descricaoInformacoes);

        nomeTela.setText(nome);
        codigoTela.setText(codigo);
        descricaoTela.setText(descricao);
    }
}
