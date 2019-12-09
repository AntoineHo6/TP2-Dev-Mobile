package View;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.dev.TP2_Mobile.R;
import java.util.ArrayList;
import Adapter.AdapterSectionMetierProf;
import Model.sectionMetier;
import Presenter.Student;

public class View_ParamEtudiant extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Student nomEtudiant;
    private AdapterSectionMetierProf mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<sectionMetier> section;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat_Light_DarkActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_param_metier_etudiant_prof);
        Intent intent = getIntent();
        nomEtudiant = intent.getParcelableExtra("ETUDIANT");
        getSupportActionBar().setTitle(nomEtudiant.getName());
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
        section = new ArrayList<sectionMetier>();

        recyclerView = (RecyclerView) findViewById(R.id.recycleview_metier_etudiant);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        ajouterDonnerList();

        mAdapter = new AdapterSectionMetierProf(section);
        recyclerView.setAdapter(mAdapter);

        ajouterAction();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }


    private void ajouterAction(){
        mAdapter.setOnItemClickListener(new AdapterSectionMetierProf.OnItemClickListener() {
            @Override
            public void checkBox(){
                //Notifier les changements
            }

            @Override
            public void onEditClick(int position) {
                //Ouvre l'activité visualiser section
            }
        });
    }

    private void ajouterDonnerList(){
        section.add(new sectionMetier("Matières et produits", false));
        section.add(new sectionMetier("Équipements", false));
        section.add(new sectionMetier("Tâche et exigences", false));
        section.add(new sectionMetier("Individu", false));
        section.add(new sectionMetier("Environnement de travail", false));
        section.add(new sectionMetier("Ressources humaines", false));
    }

    public void confirmerButtonClick(View view) {
        //sauvegarderDonner();
        //Retour a l'activité precedente
        finish();
    }

    public void sauvegerderDonner(){
        //Code pour sauvegarder les changements dans la BD
    }
}
