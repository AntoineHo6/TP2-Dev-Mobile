package View;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.dev.TP2_Mobile.R;

import java.util.ArrayList;

import Model.Mod_DBHelper;

public class View_LoginPage {

    AppCompatActivity activity;
    Mod_DBHelper DataBase;
    Button login;

    public View_LoginPage(AppCompatActivity activity) {
        this.activity = activity;
        login = activity.findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMetierEtudiant(0, "add");
            }
        });
        DataBase = new Mod_DBHelper(this.activity);
        ConstraintLayout constraintLayout = activity.findViewById(R.id.loginpage_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }

    private void openMetierEtudiant(int i, String add) {
        Intent intent = new Intent(activity.getApplicationContext(), View_MetierEtudiant.class);
        DataBase.ConnectUser("lol", "sjsjs");
        activity.startActivity(intent);

    }
}



