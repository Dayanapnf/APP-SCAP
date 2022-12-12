package br.ufc.quixada.scap;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import br.ufc.quixada.scap.Model.User;
import br.ufc.quixada.scap.databinding.ActivityTelaPerfilBinding;


public class TelaPerfil extends AppCompatActivity {
    private EditText nome;
    private EditText email;
    private EditText senha;
    private TextView sair;
    private AppCompatButton salvar;
    private ImageView imageView;
    TelaPerfil telaPerfil;
    Uri imageUri;
    ActivityTelaPerfilBinding binding;
    StorageReference storageReference;
    ProgressDialog progressDialog;


    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_perfil);

        nome = findViewById(R.id.edit_Nome);
        email = findViewById(R.id.edit_email);
        senha = findViewById(R.id.edit_senha);
        sair = findViewById(R.id.title_Sair);
        imageView = findViewById(R.id.imageview_foto_perfil);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(telaPerfil);

                String[] options = {"Escolher foto no dispositivo", " Abrir câmera"};
                
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which == 0){
                            selectImage();
                            uploadImage();
                        }
                        if (which == 1){
                            
                        }
                    }
                }).create().show();
                
            }
        });


    }

    private void uploadImage() {

        progressDialog  = new ProgressDialog(this);
        progressDialog.setTitle("Uploading file...");
        progressDialog.show();

        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy", new Locale("pt","BR"));
        Date now = new Date();
        String filename = formatter.format(now);
        storageReference = FirebaseStorage.getInstance().getReference("images/" + filename);
        storageReference.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                binding.imageviewFotoPerfil.setImageURI(null);
                Toast.makeText(TelaPerfil.this, "Sucesso", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(TelaPerfil.this, "Falha", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void selectImage() {
        Intent intent = new Intent();
        intent.setType("/image/");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && data != null && data.getData() != null){
            imageUri = data.getData();
            binding.imageviewFotoPerfil.setImageURI(imageUri);
        }
    }
}