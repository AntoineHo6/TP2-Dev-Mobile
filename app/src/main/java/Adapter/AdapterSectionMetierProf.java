package Adapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.dev.TP2_Mobile.R;


public class AdapterSectionMetierProf
        extends RecyclerView.Adapter<AdapterSectionMetierProf.SectionMetierProfViewHolder> {

    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void checkBox();
    }

    public static class SectionMetierProfViewHolder extends RecyclerView.ViewHolder{

        public TextView letter;
        public CheckBox checkBoxActif;

        public SectionMetierProfViewHolder(View view, final OnItemClickListener listener){
            super(view);
            letter = view.findViewById(R.id.lettreMetier);
            checkBoxActif = view.findViewById(R.id.checkBoxMetier);

            checkBoxActif.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.checkBox();
                        }
                    }
                }
            });
        }

    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public SectionMetierProfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull SectionMetierProfViewHolder holder, int position) {

    }


}
