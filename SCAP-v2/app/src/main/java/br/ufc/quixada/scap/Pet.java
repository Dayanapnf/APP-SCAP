package br.ufc.quixada.scap;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Pet extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);

        bottomNavigationView = findViewById(R.id.bottom_menu);


        bottomNavigationView.setSelectedItemId(R.id.bottom_menu_pet );

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.bottom_menu_atividades:

                        startActivity(new Intent(getApplicationContext(), ListarAtividade.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.bottom_menu_inicio:

                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.bottom_menu_adicionar:
                        startActivity(new Intent(getApplicationContext(),FormAddAtividade.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.bottom_menu_pet:


                        return true;
                }
                return false;
            }
        });


    }
}

