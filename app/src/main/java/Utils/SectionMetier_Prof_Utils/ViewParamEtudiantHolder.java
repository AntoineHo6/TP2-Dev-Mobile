package Utils.SectionMetier_Prof_Utils;


import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dev.TP2_Mobile.R;

import Contract.MainContract;

public class ViewParamEtudiantHolder
        extends RecyclerView.ViewHolder
        implements MainContract.MvpView {

    TextView letterJob;
    CheckBox checkBoxJob;


    public ViewParamEtudiantHolder(MainContract.MvpView itemView) {
        super((android.view.View) itemView);
        letterJob = ((android.view.View) itemView).findViewById(R.id.lettreMetier);
        checkBoxJob = ((android.view.View) itemView).findViewById(R.id.checkBoxMetier);
    }


    @Override
    public void setSectionTitle(String letter) {
        letterJob.setText(letter);
    }

    @Override
    public void setIsActif(boolean isActif) {
        checkBoxJob.setChecked(isActif);
    }
}
