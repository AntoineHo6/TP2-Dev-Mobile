package Presenter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dev.TP2_Mobile.R;

import Model.Mod_DBHelper;

public class VisualiserSectionFrag extends Fragment {

    private String question;
    private String reponse;
    private Mod_DBHelper DataBase;

    public VisualiserSectionFrag(String question, String reponse, Mod_DBHelper DataBase) {
        this.question = question;
        this.reponse = reponse;
        this.DataBase = DataBase;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_visualiser_section, container, false);

        TextView tvQuestion = view.findViewById(R.id.tvQuestion);
        String test = DataBase.GetData(Mod_DBHelper.Table.QUESTIONS_DEFAULT, "1");
        tvQuestion.setText(test);

        TextView tvReponse = view.findViewById(R.id.tvReponse);
        tvReponse.setText(reponse);

        return view;
    }
}
