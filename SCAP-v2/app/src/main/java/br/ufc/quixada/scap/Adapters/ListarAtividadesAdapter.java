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

    ArrayList<Atividades> atividadesArrayList;

    public ListarAtividadesAdapter(Context context,ArrayList<Atividades> arrayList){
        this.context = context;
        this.atividadesArrayList = arrayList;
    }

    @NonNull
    @Override
    public ListarAtividadesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_atividades,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListarAtividadesAdapter.MyViewHolder holder, int position) {
         Atividades atividades = atividadesArrayList.get(position);
         holder.nome_atv.setText(atividades.getNome_da_atividade());
         holder.autor.setText(atividades.getNome_da_atividade());
    }

    @Override
    public int getItemCount() {
        return atividadesArrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nome_atv, autor;

        public MyViewHolder(@NonNull View atividadeView){
            super(atividadeView);
            nome_atv = atividadeView.findViewById(R.id.txtAtvNome);
            autor = atividadeView.findViewById(R.id.txtAtvAutor);
        }
    }
}
