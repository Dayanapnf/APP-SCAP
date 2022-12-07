package br.ufc.quixada.scap;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

import br.ufc.quixada.scap.Adapters.MinhasAtividadesAdapter;
import br.ufc.quixada.scap.DAO.AtividadesDAOFirebase;
import br.ufc.quixada.scap.Model.Atividades;

public class FormAddAtividade extends AppCompatActivity {

    int id;
    EditText editNomeAtv, editDescricaoAtv, editObjetivoAtv, editMetodologiaAtv, editResultadosAtv,editAvaliacaoAtv;
    AppCompatButton btnAdd;
    static ArrayList<Atividades> atividadesList;
    BottomNavigationView bottomNavigationView;
    MinhasAtividadesAdapter adapter;
    AtividadesDAOFirebase atividadesDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_add_atividade);
        //   getSupportActionBar().hide();

        atividadesDAO = (AtividadesDAOFirebase) AtividadesDAOFirebase.getInstance(this);
        atividadesDAO.init();

        bottomNavigationView = findViewById(R.id.bottom_menu);

        adapter = new MinhasAtividadesAdapter(this, atividadesList);
        bottomNavigationView.setSelectedItemId(R.id.bottom_menu_adicionar );

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.bottom_menu_atividades:

                        startActivity(new Intent(getApplicationContext(), ListarAtividade.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.bottom_menu_inicio:

                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.bottom_menu_adicionar:

                        return true;

                    case R.id.bottom_menu_pet:

                        startActivity(new Intent(getApplicationContext(),Pet.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });



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

    public void notifyAdapter(){
        adapter.notifyDataSetChanged();
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

       atividadesDAO.addAtividade(a);
       adapter.notifyDataSetChanged();

    }

}
