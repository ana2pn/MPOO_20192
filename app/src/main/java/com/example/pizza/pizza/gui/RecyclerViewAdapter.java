package com.example.pizza.pizza.gui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizza.InformacoesPizza;
import com.example.pizza.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<String> mNome = new ArrayList<>();
    private ArrayList<String> mCodigo = new ArrayList<>();
    private ArrayList<String> mDescricao = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> nome, ArrayList<String> codigo, ArrayList<String> descricao) {
        this.mNome = nome;
        this.mCodigo = codigo;
        this.mDescricao = descricao;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.nome.setText(mNome.get(position));
        holder.codigo.setText(mCodigo.get(position));

        holder.btnVerMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, InformacoesPizza.class);
                intent.putExtra("nome", mNome.get(position));
                intent.putExtra("codigo", mCodigo.get(position));
                intent.putExtra("descricao", mDescricao.get(position));
                mContext.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return mNome.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nome;
        TextView codigo;
        RelativeLayout parentLayout;
        Button btnVerMais;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nome);
            codigo = itemView.findViewById(R.id.codigo);
            btnVerMais = itemView.findViewById(R.id.btnVerMais);
            parentLayout = itemView.findViewById(R.id.parent_layout);

        }
    }
}
