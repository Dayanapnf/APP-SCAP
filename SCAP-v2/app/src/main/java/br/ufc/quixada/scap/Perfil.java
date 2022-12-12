package br.ufc.quixada.scap;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import br.ufc.quixada.scap.auth.FormLogin;

public class Perfil extends AppCompatActivity {

    TextView deslogar;
    private EditText nome;
    private EditText email;
    private EditText senha;
    private TextView sair;
    private FloatingActionButton btn_imagem ;
    private AppCompatButton salvar;
    ImageView imageView;

    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        db = FirebaseFirestore.getInstance();
        

        dataInicialize();

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},0);
        }

        onStart();




        deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Perfil.this, FormLogin.class);
                startActivity(intent);
                finish();
            }
        });
        
        btn_imagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tirarFoto();
            }
        });
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updUser();
                Intent intent = new Intent(Perfil.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void tirarFoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imagem = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imagem);
        }
        super.onActivityResult(requestCode,resultCode,data);
    }

    protected void onStart(){
        super.onStart();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        DocumentReference documentReference = db.collection("Usuarios").document(uid);
        documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if(documentSnapshot != null){
                    nome.setText(documentSnapshot.getString("nome"));
                    email.setText(documentSnapshot.getString("email"));

                }else{
                    Toast.makeText(Perfil.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void dataInicialize(){
        nome = findViewById(R.id.edit_Nome);
        email = findViewById(R.id.edit_email);
        deslogar = findViewById(R.id.title_Sair);
        btn_imagem = findViewById(R.id.btn_add_foto);
        imageView = findViewById(R.id.image_user);
        salvar = findViewById(R.id.bt_salvar);
    }
    public void  updUser (){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        String nome_new = nome.getText().toString();
        String email_new = email.getText().toString();

        db.collection("Usuarios").document(uid).update("nome", nome_new,
                "email",email_new).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(Perfil.this,"Update",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Perfil.this,"Error",Toast.LENGTH_SHORT).show();
            }
        });

    }

}