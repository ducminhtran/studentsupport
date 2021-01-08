package com.meowbeos.studentsupport.adapter.marks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.meowbeos.studentsupport.R;
import com.meowbeos.studentsupport.model.Subjects;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHolder> {

    Context context;
    List<Subjects> subjects;

    public SubjectAdapter(Context context, List<Subjects> subjects) {
        this.context = context;
        this.subjects = subjects;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_subject,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(subjects.get(position).getNameSubjects());
        holder.credits.setText(subjects.get(position).getNumberCredits());
        holder.mid.setText(subjects.get(position).getMidtermMarks());
        holder.end.setText(subjects.get(position).getEndtermMarks());

    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,credits,mid,end;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtSubjectName);
            credits = itemView.findViewById(R.id.txtNumberCredits);
            mid = itemView.findViewById(R.id.txtMidMark);
            end = itemView.findViewById(R.id.txtEndMark);
        }
    }
}
