package br.ufc.quixada.scap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import br.ufc.quixada.scap.Adapters.MinhasAtividadesAdapter;
import br.ufc.quixada.scap.Model.Atividades;

public class ListarAtividade extends AppCompatActivity {
    FormAddAtividade f;
    MinhasAtividadesAdapter adapter;
    RecyclerView recyclerView = findViewById(R.id.recycle_view_listar);

    ArrayList<Atividades> minhasAtividades;
    TextView txtNome, txtDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_atividade);

        minhasAtividades = f.getAtividadesList();



        recyclerView = findViewById(R.id.recycle_view_listar);
        adapter = new MinhasAtividadesAdapter(minhasAtividades);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration( this, DividerItemDecoration.VERTICAL));

    }
}
