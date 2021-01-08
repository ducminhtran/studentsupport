package com.meowbeos.studentsupport.adapter.marks;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.meowbeos.studentsupport.R;
import com.meowbeos.studentsupport.activity.competition.CompetitionDetailFragment;
import com.meowbeos.studentsupport.activity.marks.SubjectFragment;
import com.meowbeos.studentsupport.model.Semester;

import java.util.List;

public class SemesterAdapter extends RecyclerView.Adapter<SemesterAdapter.ViewHolder> {

    Context context;
    List<Semester> semesters;

    public SemesterAdapter(Context context, List<Semester> semesters) {
        this.context = context;
        this.semesters = semesters;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_semester,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(semesters.get(position).getNameSemester());
        holder.year.setText("Năm học " + semesters.get(position).getSchoolYear());
        holder.date.setText("Thời gian "+ semesters.get(position).getDateSemester());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                SubjectFragment fragment = new SubjectFragment();
                Bundle bundle = new Bundle();
                bundle.putString("ID",String.valueOf(semesters.get(position).getIdSemester()));
                fragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack(null).commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return semesters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,year,date;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txtSemesterName);
            year = itemView.findViewById(R.id.txtSemesterYear);
            date = itemView.findViewById(R.id.txtSemesterDate);
            linearLayout = itemView.findViewById(R.id.linear_layout_Semester);
        }
    }
}
