package br.ufc.quixada.scap;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FormLogin extends AppCompatActivity {

    private FirebaseAuth auth;
    EditText edit_senha,edit_email;
    private TextView text_tela_de_cadastro;
    private AppCompatButton appCompatButton;
    String email,senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        auth = FirebaseAuth.getInstance();


        IniciarComponentes();

        text_tela_de_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FormLogin.this,FormCadastro.class);
                startActivity(intent);
            }
        });



        appCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = edit_email.getText().toString();
                senha = edit_senha.getText().toString();

                if(email.isEmpty() || senha.isEmpty()){
                    Toast toast = Toast.makeText(getApplicationContext(), "Preencha todos os campos!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Intent intent = new Intent(FormLogin.this, MainActivity.class);
                                startActivity(intent);
                            }
                            else {
                                String error = task.getException().toString();
                                Toast.makeText(
                                        FormLogin.this,
                                        "Login inválido",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });

        ImageView imageViewShowHidePwd = findViewById(R.id.olho_senha);
        imageViewShowHidePwd.setImageResource(R.drawable.ic_baseline_visibility_off_24);
        imageViewShowHidePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit_senha.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())) {

                    //if passaword is visible then hide it
                    edit_senha.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //change icon
                    imageViewShowHidePwd.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                } else {
                    edit_senha.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    imageViewShowHidePwd.setImageResource(R.drawable.ic_baseline_remove_red_eye_24);
                }
            }

        });
    }
    private void IniciarComponentes(){
        edit_email = findViewById(R.id.edit_email);
        edit_senha = findViewById(R.id.edit_senha);
        text_tela_de_cadastro= findViewById(R.id.text_tela_cadastro);
        appCompatButton = findViewById(R.id.button);

    }
}