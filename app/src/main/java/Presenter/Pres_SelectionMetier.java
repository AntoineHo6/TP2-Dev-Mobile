package Presenter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

    View_SelectionMetier view;
    Mod_SelectionMetier mod = new Mod_SelectionMetier();
    Fragment selectedFragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    private ImageView imageView;
    private static final int REQUEST_IMAGE_CAPTURE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pres__selection_metier);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction t = fragmentManager.beginTransaction();


        Fragment_Home1 fragment = new Fragment_Home1();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();





        view = new View_SelectionMetier(this);
        Button back = (Button) findViewById(R.id.btnBackEtudiant);
        Button forward = (Button) findViewById(R.id.btnFowardEtudiant);


        //imageView = fragment.getImageViewPhoto();

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onClickButtonBack(v);
            }
        });
        forward.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                onClickButtonForward(v);
            }
        });

//        selectedFragment = new Fragment_Home1();
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nagivation);
//        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }

    private void onClickButtonForward(View v) {
        Fragment fragment;
        fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if(fragment instanceof Fragment_Home1){
            fragment = new Fragment_Home2();
        }

        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment,"demofragment");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    private void onClickButtonBack(View v) {
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);
        Fragment Newfragment = fragmentManager.findFragmentById(R.id.fragment_container);
        if(fragment!=null){
            if(fragment instanceof Fragment_Home2){
                fragmentTransaction.remove(fragment);
                fragmentTransaction.commit();
                Newfragment = new Fragment_Home1();
            }

        }else{
            super.onBackPressed();
        }

        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,Newfragment,"demofragment");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        //takePicture(v);
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





}
