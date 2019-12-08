package View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.TP2_Mobile.R;

import java.util.ArrayList;

import Adapter.AdapterSectionMetierProf;
import Model.sectionMetier;

public class View_ParamEtudiant extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterSectionMetierProf mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<sectionMetier> section;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_param_etudiant);
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

    private void ajouterAction(){
        mAdapter.setOnItemClickListener(new AdapterSectionMetierProf.OnItemClickListener() {
            @Override
            public void checkBox(){

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
}
