package br.ufc.quixada.scap;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import br.ufc.quixada.scap.DAO.AtividadesDAOFirebase;

public class Edit_atividade extends AppCompatActivity {
    EditText editNomeAtv, editDescricaoAtv, editObjetivoAtv, editMetodologiaAtv, editResultadosAtv, editAvaliacaoAtv;
    Button bt_upd;
    RadioGroup radioGroup;
    String NomeAtv, DescricaoAtv, ObjetivoAtv, MetodologiaAtv, ResultadosAtv, AvaliacaoAtv;

    AtividadesDAOFirebase dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_atividade);

        dataInitialize();

        Bundle bundle = getIntent().getExtras();
        //upd//get dados
            NomeAtv = bundle.getString("tipo_da_atv");
            DescricaoAtv = bundle.getString("nome_da_atv");
            DescricaoAtv = bundle.getString("descricao");
            ObjetivoAtv = bundle.getString("objetivo");
            MetodologiaAtv = bundle.getString("metodologia");
            ResultadosAtv = bundle.getString("resultados");
            AvaliacaoAtv = bundle.getString("avaliacao");

            //set dados
            editNomeAtv.setText(NomeAtv);
            editDescricaoAtv.setText(DescricaoAtv);
            editObjetivoAtv.setText(ObjetivoAtv);
            editMetodologiaAtv.setText(MetodologiaAtv);
            editResultadosAtv.setText(ResultadosAtv);
            editAvaliacaoAtv.setText(AvaliacaoAtv);



    }
    public void dataInitialize() {

        editNomeAtv = findViewById(R.id.edit_nome_atividade);
        editDescricaoAtv = findViewById(R.id.edit_descricao);
        editObjetivoAtv = findViewById(R.id.edit_objetivo);
        editMetodologiaAtv = findViewById(R.id.edit_metodologia);
        editResultadosAtv = findViewById(R.id.edit_resultados);
        editAvaliacaoAtv = findViewById(R.id.edit_avaliacao);
        bt_upd = findViewById(R.id.bt_upd);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup_tipo_da_atividade);
    }
}