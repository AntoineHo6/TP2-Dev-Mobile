package View;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.TP2_Mobile.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import Contract.MainContract;
import Model.Mod_Student;
import Presenter.Pres_SectionMetier_Prof;
import Utils.SectionMetier_Prof_Utils.RepositariesRecyclerAdapter;

/**
 * Affiche l'ecran parametre étudiant professeur
 */
public class View_ParamEtudiant extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Pres_SectionMetier_Prof mPresentateur;
    private RecyclerView.LayoutManager  layoutManager;

    public View_ParamEtudiant() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_param_etudiant);

        recyclerView = findViewById(R.id.recyclerViewParamEtudiant);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPresentateur = new Pres_SectionMetier_Prof( this);

        RepositariesRecyclerAdapter adapter = new RepositariesRecyclerAdapter(mPresentateur);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        //DrawerLayout drawer = findViewById(R.id.drawer_layout);
        //NavigationView navigationView = findViewById(R.id.nav_view);
        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                //this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawer.addDrawerListener(toggle);
        //toggle.syncState();
        //navigationView.setNavigationItemSelectedListener(this);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
