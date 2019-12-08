package Presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.TP2_Mobile.R;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    private ArrayList<Student> list;
    private OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(int position);

        void onDeleteClick(int position);
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        public TextView tvNomEtudiant;
        public ProgressBar pbEtudiant;

        public StudentViewHolder(View view, final OnItemClickListener listener) {
            super(view);
            tvNomEtudiant = view.findViewById(R.id.nomEtudiantTabBord);
            pbEtudiant = view.findViewById(R.id.progressBarTabBord);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

    public StudentAdapter(ArrayList<Student> list) {
        this.list = list;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_tab_bord, parent, false);
        StudentViewHolder ivh = new StudentViewHolder(v, listener);
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = list.get(position);
        holder.tvNomEtudiant.setText(student.getName());
        holder.pbEtudiant.setProgress(student.getProgression());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    }



