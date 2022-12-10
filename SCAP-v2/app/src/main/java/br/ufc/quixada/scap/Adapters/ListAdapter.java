package br.ufc.quixada.scap.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

import br.ufc.quixada.scap.Model.Atividades;
import br.ufc.quixada.scap.R;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    List<Atividades> itemList;
    Context context;

    private OnItemClickListener itemListener;

    public ListAdapter(List<Atividades> itemList) {
        this.itemList = itemList;
    }

    public interface OnItemClickListener {
        void onItemDetail(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        itemListener = listener;
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_atividades, parent, false);
        ListAdapter.ViewHolder viewHolder = new ListAdapter.ViewHolder(view, itemListener);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {

        FirebaseFirestore.getInstance().collection("Atividades")
                .whereEqualTo("id", itemList.get(position).getDocumentID())
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Atividades atv = document.toObject(Atividades.class);
                            holder.nomeAtv.setText(atv.getNome_da_atividade());
                            holder.autorAtv.setText(atv.getDescricao_da_atividade());

                        }
                    }
                });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomeAtv;
        TextView autorAtv;

        public ViewHolder(View view, OnItemClickListener itemListener) {
            super(view);
            nomeAtv = view.findViewById(R.id.txtAtvNome);
            autorAtv = view.findViewById(R.id.txtAtvAutor);
        }
    }
}
