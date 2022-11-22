package br.ufc.quixada.scap;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

import br.ufc.quixada.scap.fragments.AdicionarFragment;
import br.ufc.quixada.scap.fragments.AtividadesFragment;
import br.ufc.quixada.scap.fragments.Pet_siFragment;
import br.ufc.quixada.scap.fragments.PrincipalFragment;

public class MainActivity extends AppCompatActivity{

    private Toolbar toolbar;
    BottomNavigationView  bottomNavigationView;
    Intent intent;
    FloatingActionButton fbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_menu);
        fbt = findViewById(R.id.bt_add);


        fragmentRepl(new PrincipalFragment());



        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottom_menu_inicio:
                        fragmentRepl(new PrincipalFragment());
                        break;
                    case R.id.bottom_menu_atividades:
                        fragmentRepl(new AtividadesFragment());
                        break;
                    case R.id.bottom_menu_adicionar:
                        fragmentRepl(new AdicionarFragment());
                        break;
                    case R.id.bottom_menu_pet:
                        fragmentRepl(new Pet_siFragment());
                        break;
                }
                return true;
            }
        });
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FormAddAtividade.class);
                startActivity(intent);
            }
        });


    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    private void fragmentRepl(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
    public boolean onOptionsItemSelected( MenuItem item){
        switch (item.getItemId()){
            case R.id.profile:
                startActivity(new Intent(this,TelaPerfil.class));
                break;
            case R.id.list_item:
                startActivity(new Intent(this,ListarAtividade.class));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
        return true;
    }




}