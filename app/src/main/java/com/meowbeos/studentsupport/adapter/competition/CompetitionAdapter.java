package com.meowbeos.studentsupport.adapter.competition;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.meowbeos.studentsupport.R;
import com.meowbeos.studentsupport.activity.competition.CompetitionDetailFragment;
import com.meowbeos.studentsupport.activity.news.NewsDetailFragment;
import com.meowbeos.studentsupport.model.Competition;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CompetitionAdapter extends RecyclerView.Adapter<CompetitionAdapter.ViewHolder> {

    Context context;
    List<Competition> competitions;

    public CompetitionAdapter(Context context, List<Competition> competitions) {
        this.context = context;
        this.competitions = competitions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_competition,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(competitions.get(position).getTitleCompetition());
        holder.date.setText(competitions.get(position).getDatePost());
        Picasso.get().load(competitions.get(position).getUrlBanner()).error(R.drawable.error).into(holder.img);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                CompetitionDetailFragment fragment = new CompetitionDetailFragment();
                Bundle bundle = new Bundle();
                bundle.putString("ID",String.valueOf(competitions.get(position).getIdCompetition()));
                fragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack(null).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return competitions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,date;
        ImageView img;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtTitleCompetition);
            date = itemView.findViewById(R.id.txtDatePostCompetition);
            img = itemView.findViewById(R.id.imgCompetition);
            linearLayout = itemView.findViewById(R.id.linear_layout_Competition);
        }
    }
}
