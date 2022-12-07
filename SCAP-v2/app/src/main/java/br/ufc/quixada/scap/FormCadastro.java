package br.ufc.quixada.scap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class FormCadastro extends AppCompatActivity {
    //EditText editNome, editEmail,editSenha;
    AppCompatButton appCompatButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);
        IniciarComponentes();

        appCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FormCadastro.this, FormLogin.class);
                startActivity(intent);
            }
        });
    }


    private void IniciarComponentes(){

        appCompatButton = findViewById(R.id.bt_cadastrar);
    }
}