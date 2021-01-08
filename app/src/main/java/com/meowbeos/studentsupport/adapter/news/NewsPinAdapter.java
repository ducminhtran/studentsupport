package com.meowbeos.studentsupport.adapter.news;

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
import com.meowbeos.studentsupport.activity.news.NewsDetailFragment;
import com.meowbeos.studentsupport.model.NewsPins;
import com.squareup.picasso.Picasso;

public class NewsPinAdapter extends RecyclerView.Adapter<NewsPinAdapter.ViewHolder> {

    Context context;
    NewsPins news;

    public NewsPinAdapter(Context context, NewsPins news) {
        this.context = context;
        this.news = news;
    }

    @NonNull
    @Override
    public NewsPinAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_news_pin, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsPinAdapter.ViewHolder holder, int position) {
        holder.title.setText(news.getListNews().get(position).getTitleNews());
        Picasso.get().load(news.getListNews().get(position).getUrlBanner()).error(R.drawable.error).into(holder.img);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                NewsDetailFragment fragment = new NewsDetailFragment();
                Bundle bundle = new Bundle();
                bundle.putString("ID",String.valueOf(news.getListNews().get(position).getIdNews()));
                fragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack(null).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return news.getListNews().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView img;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.txtTitleNewsPin);
            img = itemView.findViewById(R.id.imgNewsPin);
            linearLayout = itemView.findViewById(R.id.linear_layout_NewsPin);
        }
    }
}
