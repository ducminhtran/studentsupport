package com.meowbeos.studentsupport.adapter.groupsubjects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.meowbeos.studentsupport.R;
import com.meowbeos.studentsupport.model.Notification;

import java.util.List;

public class GroupsDetailAdapter extends RecyclerView.Adapter<GroupsDetailAdapter.ViewHolder> {

    Context context;
    List<Notification> notifications;

    public GroupsDetailAdapter(Context context, List<Notification> notifications) {
        this.context = context;
        this.notifications = notifications;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_notification_group, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.content.setText(notifications.get(position).getContentNotification());
        holder.date.setText(notifications.get(position).getDateNotification());
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView content, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            content = itemView.findViewById(R.id.txtContentNotification);
            date = itemView.findViewById(R.id.txtDateNotification);
        }
    }
}
