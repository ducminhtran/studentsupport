package com.meowbeos.studentsupport.adapter.groupsubjects;

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
import com.meowbeos.studentsupport.activity.groupsubjects.GroupsDetailFragment;
import com.meowbeos.studentsupport.activity.news.NewsDetailFragment;
import com.meowbeos.studentsupport.model.GroupSubjects;

import java.util.List;

public class GroupsAdapter extends RecyclerView.Adapter<GroupsAdapter.ViewHolder> {

    Context context;
    List<GroupSubjects> groupSubjectsList;

    public GroupsAdapter(Context context, List<GroupSubjects> groupSubjectsList) {
        this.context = context;
        this.groupSubjectsList = groupSubjectsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_groups, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameSubject.setText(groupSubjectsList.get(position).getNameSubjects());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                GroupsDetailFragment fragment = new GroupsDetailFragment();
                Bundle bundle = new Bundle();
                bundle.putString("ID",String.valueOf(groupSubjectsList.get(position).getIdGroupSubjects()));
                fragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack(null).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return groupSubjectsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameSubject;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameSubject = itemView.findViewById(R.id.txtNameSubject);
            linearLayout = itemView.findViewById(R.id.linear_layout_Groups);
        }
    }
}
