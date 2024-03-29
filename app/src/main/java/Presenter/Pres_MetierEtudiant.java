package Presenter;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.dev.TP2_Mobile.R;
import com.google.android.material.navigation.NavigationView;

import Model.Mod_DBHelper;


public class Pres_MetierEtudiant extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    Mod_DBHelper dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metier_etudiant);

        dataBase = new Mod_DBHelper(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.logout) {
            dataBase.DisconnectUser();
            Intent intent = new Intent(getApplicationContext(),
                    Pres_LoginPage.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_accueil) {

        }
        else if (id == R.id.nav_matiere_et_produits) {
            openMetierEtudiant(1);
        }
        else if (id == R.id.nav_equipements) {
            openMetierEtudiant(2);
        }
        else if (id == R.id.nav_tache_et_exigences) {
            openMetierEtudiant(3);
        }
        else if (id == R.id.nav_individu) {
            openMetierEtudiant(4);
        }
        else if (id == R.id.nav_env_de_travail) {
            openMetierEtudiant(5);
        }
        else if (id == R.id.nav_res_humaines) {
            openMetierEtudiant(6);
        }
        else {  // envoyer un email

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openMetierEtudiant(int idSection) {
        Intent intent = new Intent(getApplicationContext(), Pres_SelectionMetier.class);
        intent.putExtra("idSection", idSection);
        startActivity(intent);
    }

}
