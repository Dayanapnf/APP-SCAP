package br.ufc.quixada.scap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FormCadastro extends AppCompatActivity {

    private FirebaseAuth auth;

    EditText edtNome;
    EditText edtEmail;
    EditText edtSenha;

    AppCompatButton appCompatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);

        IniciarComponentes();

        auth = FirebaseAuth.getInstance();


        appCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = edtNome.getText().toString();
                String email = edtEmail.getText().toString();
                String senha = edtSenha.getText().toString();


                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(
                        FormCadastro.this,
                        "Preencha todos os campos!",
                        Toast.LENGTH_SHORT).show();


                }else {

                    auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                Intent intent = new Intent(FormCadastro.this, FormLogin.class);
                                Toast.makeText(FormCadastro.this,"Sucess", Toast.LENGTH_SHORT).show();
                                startActivity(intent);
                                finish();
                            }else{
                                Toast.makeText(
                                        FormCadastro.this,
                                        "Falha no cadastro!" ,
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }

        });


    }

    private void IniciarComponentes() {

        edtNome = findViewById(R.id.edit_Nome);
        edtEmail = findViewById(R.id.edit_email);
        edtSenha = findViewById(R.id.edit_senha);
        appCompatButton = findViewById(R.id.bt_cadastrar);
    }

}


