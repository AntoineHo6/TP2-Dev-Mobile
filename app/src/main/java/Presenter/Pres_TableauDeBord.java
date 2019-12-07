package Presenter;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.dev.TP2_Mobile.R;

import Model.Mod_TableauDeBord;
import View.View_TableauDeBord;

public class Pres_TableauDeBord extends AppCompatActivity {

    View_TableauDeBord view;
    Mod_TableauDeBord model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tableau_de_bord);

        view = new View_TableauDeBord();
        model = new Mod_TableauDeBord();
    }


}
