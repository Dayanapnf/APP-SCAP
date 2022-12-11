package br.ufc.quixada.scap;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.scap.Adapters.ListarAtividadesAdapter;
import br.ufc.quixada.scap.Model.Atividades;

public class ListarAtividade extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseFirestore db;
    FirebaseAuth auth;
    ListarAtividadesAdapter atividadesAdapter;

    List<Atividades> lista = new ArrayList<>();
    List<Atividades> lista_reserva = new ArrayList<>();
    String autor;

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_atividade);

        db = FirebaseFirestore.getInstance();

        recyclerView = findViewById(R.id.recycle_view_listar);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        showData();


        bottomNavigationView = findViewById(R.id.bottom_menu);
        bottomNavigationView.setSelectedItemId(R.id.bottom_menu_atividades);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_menu_atividades:


                        return true;

                    case R.id.bottom_menu_inicio:

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.bottom_menu_adicionar:
                        startActivity(new Intent(getApplicationContext(), FormAddAtividade.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.bottom_menu_pet:

                        startActivity(new Intent(getApplicationContext(), Pet.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

    }

    private void showData() {

        db.collection("Atividades").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uid = user.getUid();
                for (DocumentSnapshot documentSnapshot : task.getResult()) {
                    Atividades atividades = new Atividades(documentSnapshot.getString("Nome da Atividade"),documentSnapshot.getString("Autor"));
                    lista.add(atividades);
                }
                    atividadesAdapter = new ListarAtividadesAdapter(ListarAtividade.this, lista);
                    recyclerView.setAdapter(atividadesAdapter);
                }

        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ListarAtividade.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

}
