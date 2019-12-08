package Presenter;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.TP2_Mobile.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import Contract.MainContract;
import Model.sectionMetier;
import Utils.SectionMetier_Prof_Utils.ViewParamEtudiantHolder;
import View.View_ParamEtudiant;
import Model.Mod_Student;

/**
 * Responsable de faire les actions de la view et de l'update le UI quant il est besoin.
 */
public class Pres_SectionMetier_Prof
        implements MainContract.MvpPresentateur {

    private Mod_Student model;
    private ArrayList<sectionMetier> section;
    private AppCompatActivity mActivity;

    public Pres_SectionMetier_Prof( AppCompatActivity activity) {
        mActivity = activity;
        // On devrait recevoir l'étudiant de l'activite precedente ou
        // un moyen de le trouver dans la BD
        model = new Mod_Student("Test", "Test");
        //setUpAnimation();
        créationSection();
    }

    public void onBindMvpViewRowAtPosition(int position, MainContract.MvpView rowView) {
        sectionMetier repo = section.get(position);
        rowView.setSectionTitle(repo.getSectionName());
        rowView.setIsActif(repo.isActive());
    }

    public int getRepositoriesRowsCount() {
        return section.size();
    }

    public void test(){
        mActivity.getSupportActionBar().setTitle(model.getNom() + " " + model.getPrenom());
    }

    /**
     * Permet de set up l'animation du background.
     */
    private void setUpAnimation(){
        ConstraintLayout constraintLayout = mActivity.findViewById(R.id.paramEtudiant_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }

    /**
     * Devrait être supprimer après implementation du API
     */
    private void créationSection(){
        section = new ArrayList<sectionMetier>();
        section.add(new sectionMetier("Matières et produits", false));
        section.add(new sectionMetier("Équipements", false));
        section.add(new sectionMetier("Tâche et exigences", false));
        section.add(new sectionMetier("Individu", false));
        section.add(new sectionMetier("Environnement de travail", false));
        section.add(new sectionMetier("Ressources humaines", false));
    }

    public interface View{
        void UpdateViews();
        void UpdateParam();
    }


}
