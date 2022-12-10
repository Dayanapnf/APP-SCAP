package br.ufc.quixada.scap;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.scap.Adapters.ListAdapter;
import br.ufc.quixada.scap.Model.Atividades;

public class ListarAtividade extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseFirestore firebaseFirestore;
    ListAdapter atividadesAdapter;
    List<Atividades> lista;
    Atividades a;
    FirebaseAuth auth;

    BottomNavigationView bottomNavigationView;
    int posicao;
    private FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_atividade);

        firebaseFirestore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        lista = new ArrayList<>();
        recyclerView = findViewById( R.id.recycle_view_listar );

        String idAtividade = getIntent().getExtras().getString("idAtividade");

        FirebaseFirestore.getInstance().collection("/Atividades")
                .whereEqualTo("documetID", idAtividade).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                final Atividades atv = document.toObject(Atividades.class);
                                lista.add(atv);
                            }
                        }
                    }
                });



        /*
        Query query = firebaseFirestore.collection("Atividades");
        FirestoreRecyclerOptions<Atividades> options = new FirestoreRecyclerOptions.Builder<Atividades>()
                .setQuery(query, Atividades.class).build();

            adapter = new FirestoreRecyclerAdapter<Atividades, AtividadesViewHolder>(options) {
            @NonNull
            @Override
            public AtividadesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_atividades, parent,false );
                return new AtividadesViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull AtividadesViewHolder holder, int position, @NonNull Atividades model) {
                holder.txtNomeAtv.setText(a.getNome_da_atividade());
                holder.txtAutorAtv.setText(a.getNome_da_atividade());
            }
        };
         recyclerView.setHasFixedSize(true);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));
         recyclerView.setAdapter(adapter);

         */




       /* scapInterface = AtividadesDAOFirebase.getInstance( this );
        scapInterface.init();
        posicao = -1;

        lista = scapInterface.getListaAtividades();
        atividadesAdapter = new ListarAtividadesAdapter(this,lista);

        recyclerView.setLayoutManager(  new LinearLayoutManager(this ));
        recyclerView.setAdapter(atividadesAdapter);
        recyclerView.addItemDecoration( new DividerItemDecoration( this, DividerItemDecoration.VERTICAL ) );
        */


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
    /*
    public void notifyAdapter(){
        atividadesAdapter.notifyDataSetChanged();
    }


    private class AtividadesViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNomeAtv;
        private TextView txtAutorAtv;

        public AtividadesViewHolder(View itemView){
            super(itemView);

            txtNomeAtv = itemView.findViewById(R.id.txtAtvNome);
            txtAutorAtv = itemView.findViewById(R.id.txtAtvAutor);

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

     */
}
