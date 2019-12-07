package Presenter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.dev.TP2_Mobile.Fragment_Home1;
import com.dev.TP2_Mobile.Fragment_Home2;
import com.dev.TP2_Mobile.Fragment_Home3;
import com.dev.TP2_Mobile.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemReselectedListener;

import Model.Mod_SelectionMetier;
import View.View_SelectionMetier;

public class Pres_SelectionMetier extends AppCompatActivity {

    View_SelectionMetier view = new View_SelectionMetier(this);
    Mod_SelectionMetier mod = new Mod_SelectionMetier();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pres__selection_metier);

        //Fragment_Home1 fragment = new Fragment_Home1();
        //getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nagivation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch(menuItem.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new Fragment_Home1();
                    break;
                case R.id.nav_home2:
                    selectedFragment = new Fragment_Home2();
                    break;
                case R.id.nav_home3:
                    selectedFragment = new Fragment_Home3();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };





}
