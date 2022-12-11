package br.ufc.quixada.scap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import br.ufc.quixada.scap.DAO.UserDAO;
import br.ufc.quixada.scap.Model.User;


public class TelaPerfil extends AppCompatActivity {
    private EditText nome;
    private EditText email;
    private EditText senha;
    private AppCompatButton salvar;


    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_perfil);

        nome = findViewById(R.id.edit_Nome);
        email = findViewById(R.id.edit_email);
        senha = findViewById(R.id.edit_senha);


        final String idUser = getIntent().getExtras().getString("idUser");

        FirebaseFirestore.getInstance().collection("/Usuarios")
                .whereEqualTo("id", idUser).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()){
                                final User u = document.toObject(User.class);
                                nome.setText(u.getNome());
                                email.setText(u.getEmail());
                                senha.setText(u.getSenha());
                                salvar.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        User usr = new User();
                                        usr.setId(idUser);
                                        usr.setNome(nome.getText().toString());
                                        usr.setEmail(email.getText().toString());
                                        usr.setSenha(senha.getText().toString());

                                        UserDAO usrDAO = UserDAO.getInstance();
                                        usrDAO.save(usr);

                                        Intent back = new Intent();
                                        setResult(Activity.RESULT_OK, back);
                                        finish();
                                    }
                                });
                            }
                        }else {
                            Log.d("EditarUser", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }





}