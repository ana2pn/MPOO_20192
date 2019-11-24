package com.example.pizza.pizza.gui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizza.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> nome;
    private ArrayList<String> codigo;
    private ArrayList<String> descricao;

    public RecyclerViewAdapter(Context context, ArrayList<String> nome, ArrayList<String> codigo, ArrayList<String> descricao) {
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return nome.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nome;
        TextView codigo;
        TextView descricao;
        Button btnVerMais;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
