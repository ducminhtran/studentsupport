package com.meowbeos.studentsupport.adapter.document;

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
import com.meowbeos.studentsupport.activity.document.DocumentFileFragment;
import com.meowbeos.studentsupport.activity.document.FileFragment;
import com.meowbeos.studentsupport.model.Document;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DocumentFileAdapter extends RecyclerView.Adapter<DocumentFileAdapter.ViewHolder> {
    Context context;
    List<Document> documents;

    public DocumentFileAdapter(Context context, List<Document> documents) {
        this.context = context;
        this.documents = documents;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_document, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.summary.setText(documents.get(position).getSummaryDocument());
        Picasso.get().load(documents.get(position).getUrlIcon()).error(R.drawable.error).into(holder.img);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FileFragment fragment = new FileFragment();
                Bundle bundle = new Bundle();
                bundle.putString("ID",String.valueOf(documents.get(position).getIdDocument()));
                fragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return documents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView summary;
        ImageView img;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            summary = itemView.findViewById(R.id.txtSummaryDocument);
            img = itemView.findViewById(R.id.imgDocumentCategory);
            linearLayout = itemView.findViewById(R.id.linear_layout_Document_Category);

        }
    }
}
