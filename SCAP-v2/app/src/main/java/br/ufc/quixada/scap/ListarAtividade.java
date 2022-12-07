package br.ufc.quixada.scap;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ListarAtividade extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_atividade);

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
}
