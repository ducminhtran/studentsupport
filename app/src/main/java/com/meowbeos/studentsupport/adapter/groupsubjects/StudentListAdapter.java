package com.meowbeos.studentsupport.adapter.groupsubjects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.meowbeos.studentsupport.R;
import com.meowbeos.studentsupport.model.Student;

import java.util.List;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.ViewHolder> {

    Context context;
    List<Student> students;

    public StudentListAdapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_student_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.code.setText(students.get(position).getCodeStudent());
        holder.name.setText(students.get(position).getNameStudent());
        holder.phone.setText(students.get(position).getPhoneStudent());
        holder.email.setText(students.get(position).getEmailStudent());

    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView code, name, phone, email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            code = itemView.findViewById(R.id.txtStudentCode);
            name = itemView.findViewById(R.id.txtStudentName);
            phone = itemView.findViewById(R.id.txtStudentPhone);
            email = itemView.findViewById(R.id.txtStudentEmail);
        }
    }
}
