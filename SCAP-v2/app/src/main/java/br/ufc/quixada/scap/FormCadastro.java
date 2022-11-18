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
                /*String nome = editNome.getText().toString();
                String email = editEmail.getText().toString();
                String senha = editSenha.getText().toString();

                if(nome.isEmpty() || email.isEmpty() || senha.isEmpty()){
                    Toast.makeText(FormCadastro.this,"Preencha todos os campos!",Toast.LENGTH_SHORT).show();
                }else{
                    cadastrarUsuario();
                }*/

                Intent intent = new Intent(FormCadastro.this, FormLogin.class);
                startActivity(intent);
            }
        });
    }

   // private void cadastrarUsuario(){}

    private void IniciarComponentes(){
        /*editNome = findViewById(R.id.edit_Nome);
        editEmail = findViewById(R.id.edit_email);
        editSenha = findViewById(R.id.edit_senha);*/
        appCompatButton = findViewById(R.id.bt_cadastrar);
    }
}