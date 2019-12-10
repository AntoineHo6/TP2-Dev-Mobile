package Presenter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import com.dev.TP2_Mobile.Fragment_Home1;
import com.dev.TP2_Mobile.Fragment_Home2;
import com.dev.TP2_Mobile.Fragment_Home3;
import com.dev.TP2_Mobile.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemReselectedListener;

import Model.Mod_DBHelper;
import Model.Mod_SelectionMetier;
import View.View_SelectionMetier;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class Pres_SelectionMetier extends AppCompatActivity{

    Mod_DBHelper DataBase;

    View_SelectionMetier view;
    Mod_SelectionMetier mod;




    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    private ImageView imageView;
    private static final int REQUEST_IMAGE_CAPTURE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pres__selection_metier);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);

        DataBase = new Mod_DBHelper(this);

        mod = new Mod_SelectionMetier();
        view = new View_SelectionMetier(this);

        int idSection = getIntent().getIntExtra("idSection", -1);
        view.updateTitreSection(idSection);

        // Stocker les questions de la section dans le model et faire afficher la premiere question dans le fragment
        int cursor = 1;
        String questionRaw = DataBase.GetData(Mod_DBHelper.Table.QUESTIONS_DEFAULT, String.valueOf(cursor));

        while (!questionRaw.equals("not_found")){
            String[] firstSplit = questionRaw.split(";");
            String section_id = firstSplit[4].split("=")[1];

            if (Integer.parseInt(section_id) == idSection) {
                String question = firstSplit[1].split("=")[1];
                mod.getQuestions().add(question);
            }

            cursor++;
            questionRaw = DataBase.GetData(Mod_DBHelper.Table.QUESTIONS_DEFAULT, String.valueOf(cursor));
        }

        Fragment frag = new Fragment_Home1(mod.getCurrentQuestion(), "Reponse 1");
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, frag).commit();

        Button back = (Button) findViewById(R.id.btnBackEtudiant);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onClickButtonBack(v);
            }
        });



        Button forward = (Button) findViewById(R.id.btnFowardEtudiant);
        forward.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onClickButtonForward(v);
            }
        });











        //imageView = fragment.getImageViewPhoto();




//        selectedFragment = new Fragment_Home1();
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nagivation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);










        //fragmentManager = getSupportFragmentManager();
        //FragmentTransaction t = fragmentManager.beginTransaction();


        //Fragment_Home1 fragment = new Fragment_Home1();
        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();


    }

    private void onClickButtonForward(View v) {
//        Fragment fragment;
//        fragment = fragmentManager.findFragmentById(R.id.fragment_container);
//
//        if(fragment instanceof Fragment_Home1){
//            fragment = new Fragment_Home2();
//        }
//
//        fragmentTransaction=fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container,fragment,"demofragment");
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();


        if (mod.getCurrentQuestionIdx() + 1 < mod.getQuestions().size()) {
            mod.incCurrentQuestionIdx();
            Fragment frag = new Fragment_Home1(mod.getCurrentQuestion(), "Reponse arbitraire");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, frag).commit();
        }


    }

    private void onClickButtonBack(View v) {
        if (mod.getCurrentQuestionIdx() != 0) {
            mod.decCurrentQuestionIdx();
            Fragment frag = new Fragment_Home1(mod.getCurrentQuestion(), "Reponse arbitraire");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, frag).commit();
        }



//        fragmentTransaction = fragmentManager.beginTransaction();
//        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
//        Fragment Newfragment = fragmentManager.findFragmentById(R.id.fragment_container);
//        if(fragment!=null){
//            if(fragment instanceof Fragment_Home2){
//                fragmentTransaction.remove(fragment);
//                fragmentTransaction.commit();
//                Newfragment = new Fragment_Home1();
//            }
//
//        }else{
//            super.onBackPressed();
//        }
//
//        fragmentTransaction=fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container,Newfragment,"demofragment");
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();






    }


    public void takePicture(View view){
        Intent imageTakeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (imageTakeIntent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(imageTakeIntent,REQUEST_IMAGE_CAPTURE);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
        //super.onActivityResult(requestCode, resultCode, data);
    }


//    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//
//            switch(menuItem.getItemId()){
//                case R.id.nav_home:
//                    selectedFragment = new Fragment_Home1();
//                    break;
//                case R.id.nav_home2:
//                    selectedFragment = new Fragment_Home2();
//                    break;
//                case R.id.nav_home3:
//                    selectedFragment = new Fragment_Home3();
//                    break;
//            }
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
//            return true;
//        }
//    };



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
