package br.ufc.quixada.scap.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

import br.ufc.quixada.scap.Model.Integrante;
import br.ufc.quixada.scap.R;

public class PetSiAdapter extends RecyclerView.Adapter<PetSiAdapter.MyViewHolder> {

    Context context;
    ArrayList<Integrante> integrantesList;

    public PetSiAdapter(Context context, ArrayList<Integrante> integrantes) {
        this.context = context;
        this.integrantesList = integrantes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Integrante integrantes = integrantesList.get(position);
        holder.tvCargo.setText(integrantes.getCargo());
        holder.tvNome.setText(integrantes.getNome());
        holder.tvEmail.setText(integrantes.getEmail());
        holder.titleImage.setImageResource(integrantes.getTitleImage());
    }

    @Override
    public int getItemCount() {
        return integrantesList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ShapeableImageView titleImage;
        TextView tvCargo,tvNome,tvEmail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleImage = itemView.findViewById(R.id.title_image);
            tvCargo = itemView.findViewById(R.id.tvCargo);
            tvNome = itemView.findViewById(R.id.tvNome);
            tvEmail = itemView.findViewById(R.id.tvEmail);
        }
    }
}

