package Presenter;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.dev.TP2_Mobile.R;

import View.View_VisualisationSection;


public class Pres_VisualiserSection extends AppCompatActivity {

    View_VisualisationSection view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualiser_section);

        Fragment frag = new VisualiserSectionFrag();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, frag).commit();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);

        view = new View_VisualisationSection(this);

        int idSection = getIntent().getIntExtra("idSection", -1);
        view.updateTitreSection(idSection);
    }


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
