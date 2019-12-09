package View;


import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.TP2_Mobile.R;

import java.util.ArrayList;
import java.util.Arrays;

import Presenter.MetierAdapter;
import Presenter.Pres_SelectionMetier;

public class View_MetierEtudiant extends AppCompatActivity {
    AppCompatActivity activity;
    ConstraintLayout layout;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MetierAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = this;
        layout = findViewById(R.id.recycleview_metier_etudiant);

        setContentView(R.layout.activity_metier_etudiant);



        buildRecycleView();

    }

    private void buildRecycleView() {
        recyclerView = findViewById(R.id.recycleview_metier_etudiant);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("M", "É", "T", "I", "E", "R"));
        adapter = new MetierAdapter(list);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new MetierAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                notifyItemSelected(position);
            }

            @Override
            public void onDeleteClick(int position) {
                notifyDeleteSelected(position);
            }
        });
    }

    private void notifyDeleteSelected(int position) {
    }

    private void notifyItemSelected(int position) {
        Intent intent = new Intent(activity.getApplicationContext(), Pres_SelectionMetier.class);
        activity.startActivity(intent);


    }
}
