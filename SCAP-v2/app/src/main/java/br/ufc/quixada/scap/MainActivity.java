package br.ufc.quixada.scap;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;

import br.ufc.quixada.scap.DAO.SCAPInterface;

public class MainActivity extends AppCompatActivity{
    private FirebaseAuth auth;
    String nameUser;
    private Toolbar toolbar;
    BottomNavigationView  bottomNavigationView;
    SCAPInterface scapInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        auth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        scapInterface = SCAPInterface.getInstance(MainActivity.this);

        bottomNavigationView = findViewById(R.id.bottom_menu);
        bottomNavigationView.setSelectedItemId(R.id.bottom_menu_inicio );
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
                        return true;
                    case R.id.bottom_menu_adicionar:
                        startActivity(new Intent(getApplicationContext(),FormAddAtividade.class));
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

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


            ImageCarousel carousel = (ImageCarousel) findViewById(R.id.carousel);

            //create list to store carousel image
            ArrayList<CarouselItem> clist = new ArrayList<>();
            clist.add(new CarouselItem(
                    R.drawable.equipe,
                    "Equipe PET-SI"
            ));

            clist.add(new CarouselItem(
                    R.drawable.campus,
                    "Campus"
            ));

            carousel.setData(clist);


    }



    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected( MenuItem item){
        switch (item.getItemId()){
            case R.id.profile:
                startActivity(new Intent(this,TelaPerfil.class));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
        return true;
    }




}