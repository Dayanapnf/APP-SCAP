package br.ufc.quixada.scap;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import br.ufc.quixada.scap.Adapters.ListarAtividadesAdapter;
import br.ufc.quixada.scap.Model.Atividades;

public class ListarAtividade extends AppCompatActivity {

    ArrayList<Atividades> lista;
    ListarAtividadesAdapter listarAtividadesAdapter;
    RecyclerView recyclerView;
    FirebaseFirestore db;
    ProgressDialog progressDialog;


    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_atividade);


        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Procurando Dados");
        progressDialog.show();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( this );
        recyclerView = findViewById( R.id.recycle_view_listar );
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(this) );

        db = FirebaseFirestore.getInstance();
        lista = new ArrayList<Atividades>();
        listarAtividadesAdapter = new ListarAtividadesAdapter(ListarAtividade.this,lista);
        recyclerView.setAdapter(listarAtividadesAdapter);
        EventChangeList();



        bottomNavigationView = findViewById(R.id.bottom_menu);
        bottomNavigationView.setSelectedItemId(R.id.bottom_menu_atividades );

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.bottom_menu_atividades:


                        return true;

                    case R.id.bottom_menu_inicio:

                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.bottom_menu_adicionar:
                        startActivity(new Intent(getApplicationContext(), FormAddAtividade.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.bottom_menu_pet:

                        startActivity(new Intent(getApplicationContext(),Pet.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }

    private void EventChangeList() {
        db.collection("Atividades").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error != null){
                    if(progressDialog.isShowing())
                        progressDialog.dismiss();
                    Log.e("Firesore error", error.getMessage());
                    return;
                }
                for(DocumentChange dc : value.getDocumentChanges()){
                    if(dc.getType() == DocumentChange.Type.ADDED){
                         lista.add(dc.getDocument().toObject(Atividades.class));
                    }
                    listarAtividadesAdapter.notifyDataSetChanged();
                    if(progressDialog.isShowing())
                        progressDialog.dismiss();

                }
            }
        });
    }


}
