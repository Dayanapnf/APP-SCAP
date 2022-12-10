package br.ufc.quixada.scap.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.ufc.quixada.scap.Model.Atividades;
import br.ufc.quixada.scap.R;

public class ListarAtividadesAdapter extends RecyclerView.Adapter<ListarAtividadesAdapter.MyViewHolder> {

    Context context;
    ArrayList<Atividades> list;

    public ListarAtividadesAdapter(Context context, ArrayList<Atividades> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_atividades,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Atividades atividades = list.get(position);
            holder.nome.setText(atividades.getNome_da_atividade());
            holder.autor.setText(atividades.getNome_da_atividade());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nome, autor;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            nome= itemView.findViewById(R.id.txtAtvNome);
            autor = itemView.findViewById(R.id.txtAtvAutor);
        }
    }



}