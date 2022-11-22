package br.ufc.quixada.scap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.ufc.quixada.scap.Adapters.MinhasAtividadesAdapter;
import br.ufc.quixada.scap.Model.Atividades;
import br.ufc.quixada.scap.fragments.AtividadesFragment;

public class FormAddAtividade extends AppCompatActivity {

    int id;
    EditText editNomeAtv, editDescricaoAtv, editObjetivoAtv, editMetodologiaAtv, editResultadosAtv,editAvaliacaoAtv;
    //RadioGroup option;
    AppCompatButton btnAdd;
    ArrayList<Atividades> atividadesList;
    MinhasAtividadesAdapter adapter;
    RecyclerView recyclerViewAtividades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_add_atividade);
        //   getSupportActionBar().hide();



        atividadesList = new ArrayList<Atividades>();

        editNomeAtv = findViewById(R.id.edit_nome_atividade);
        editDescricaoAtv = findViewById(R.id.edit_descricao);
        editObjetivoAtv = findViewById(R.id.edit_objetivo);
        editMetodologiaAtv = findViewById(R.id.edit_metodologia);
        editResultadosAtv = findViewById(R.id.edit_resultados);
        editAvaliacaoAtv = findViewById(R.id.edit_avaliacao);
        btnAdd = findViewById(R.id.bt_add);

        //dataInitialize();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addAtividade(v);

            }
        });

    }


    public ArrayList<Atividades> getAtividadesList() {
        return atividadesList;
    }

    public void setAtividadesList(ArrayList<Atividades> atividadesList) {
        this.atividadesList = atividadesList;
    }

    public void addAtividade(View view){
        String nomeAtv = editNomeAtv.getText().toString();
        String descricaoAtv = editDescricaoAtv.getText().toString();
        String objetivoAtv = editObjetivoAtv.getText().toString();
        String metodologiaAtv = editMetodologiaAtv.getText().toString();
        String resultadosAtv = editResultadosAtv.getText().toString();
        String avaliacaoAtv = editAvaliacaoAtv.getText().toString();

        Atividades a = new Atividades(nomeAtv,descricaoAtv,objetivoAtv,metodologiaAtv,resultadosAtv,avaliacaoAtv);

        atividadesList.add(a);

        Intent intent = new Intent(this, AtividadesFragment.class);

        intent.putExtra("Nome", a.getNome_da_atividade());
        intent.putExtra("Descricao", a.getDescricao_da_atividade());
        intent.putExtra("Objetivo", a.getObjetivo_da_atividade());
        intent.putExtra("Metodologia", a.getMetodologia_da_atividade());
        intent.putExtra("Resultados", a.getResultados_da_atividade());
        intent.putExtra("Avaliacao", a.getAvaliacao_da_atividade());

        Toast.makeText( this, "Atividade Adicionada", Toast.LENGTH_LONG ).show();
        startActivity(intent);


    }

}
