package Utils.SectionMetier_Prof_Utils;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.TP2_Mobile.R;

import Contract.MainContract;
import Presenter.Pres_SectionMetier_Prof;

public class RepositariesRecyclerAdapter
        extends RecyclerView.Adapter<ViewParamEtudiantHolder>{
    private final Pres_SectionMetier_Prof presenter;

    public RepositariesRecyclerAdapter(Pres_SectionMetier_Prof repositoriesPresenter){
        this.presenter = repositoriesPresenter;
    }

    @NonNull
    @Override
    public ViewParamEtudiantHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewParamEtudiantHolder((MainContract.MvpView)
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recyclerview_metier_professeur, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewParamEtudiantHolder holder, int position){
        presenter.onBindMvpViewRowAtPosition(position, holder);
    }

    @Override
    public int getItemCount(){
        return presenter.getRepositoriesRowsCount();
    }

}
