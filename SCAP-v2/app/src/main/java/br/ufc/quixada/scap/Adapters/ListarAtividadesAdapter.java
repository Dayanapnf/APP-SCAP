package br.ufc.quixada.scap.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.ufc.quixada.scap.ListarAtividade;
import br.ufc.quixada.scap.Model.Atividades;
import br.ufc.quixada.scap.R;

public class ListarAtividadesAdapter extends RecyclerView.Adapter<ViewHolder> {
    ListarAtividade listarAtividade;
    List<Atividades> atividadesList;
    Context context;

    public ListarAtividadesAdapter(ListarAtividade listarAtividade, List<Atividades> atividadesList) {
        this.listarAtividade = listarAtividade;
        this.atividadesList = atividadesList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_atividades, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                   String nome = atividadesList.get(position).getNome_da_atividade();
                   String autor = atividadesList.get(position).getAutor();

                Toast.makeText(listarAtividade,nome + "\n" + autor,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nome.setText(atividadesList.get(position).getNome_da_atividade());
        holder.autor.setText(atividadesList.get(position).getAutor());
    }

    @Override
    public int getItemCount() {
        return atividadesList.size();
    }
}