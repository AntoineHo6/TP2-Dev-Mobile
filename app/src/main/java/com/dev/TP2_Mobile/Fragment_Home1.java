package com.dev.TP2_Mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_Home1 extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        Button back = (Button) container.findViewById(R.id.btnBackEtudiant);
//        Button forward = (Button) container.findViewById(R.id.btnFowardEtudiant);
//
//        back.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                onClickButtonBack(v);
//            }
//        });
//        forward.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                onClickButtonForward(v);
//            }
//        });

        return inflater.inflate(R.layout.fragment_home, container, false);


    }

//    private void onClickButtonForward(View v) {
//        //this.onBa;
//    }
//
//    private void onClickButtonBack(View v) {
//
//    }

    @Override
    public void onClick(View v) {



        System.out.println("test");

    }
}
