package com.meowbeos.studentsupport.activity.groupsubjects;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.meowbeos.studentsupport.R;
import com.meowbeos.studentsupport.adapter.groupsubjects.GroupsDetailAdapter;
import com.meowbeos.studentsupport.constants.STConstant;
import com.meowbeos.studentsupport.model.DetailGroupSubjects;
import com.meowbeos.studentsupport.service.ServiceAPI;
import com.meowbeos.studentsupport.utils.StringUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GroupsDetailFragment extends Fragment {

    private static final String TAG = "GroupsDetail";
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ConstraintLayout constraintLayout;

    View view;
    TextView name, phone, email;
    RecyclerView recNotification;
    Button btnStudentList;
    String idGroupSubjects;

    GroupsDetailAdapter groupsDetailAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_groups_detail, container, false);

        initComponent();
        setData();
        getDetailGroupSubjects(StringUtil.generateAPIKey(),idGroupSubjects);
        addEvent();

        return view;
    }

    private void initComponent() {
        name = view.findViewById(R.id.txtTeacherName);
        phone = view.findViewById(R.id.txtTeacherPhoneNumber);
        email = view.findViewById(R.id.txtTeacherEmail);
        btnStudentList = view.findViewById(R.id.btnStudentList);

        recNotification = view.findViewById(R.id.recNotificationGroupSubject);
    }

    private void setData() {
        Bundle bundle = this.getArguments();
        idGroupSubjects = bundle.getString("ID");
    }

    private void getDetailGroupSubjects(String apiKey, String idGroupSubjects) {
        ServiceAPI serviceAPI = new Retrofit.Builder()
                .baseUrl(STConstant.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ServiceAPI.class);

        compositeDisposable.add(serviceAPI.detailGroupSubjects(apiKey,idGroupSubjects)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        );
    }

    private void handleResponse(DetailGroupSubjects detailGroupSubjects) {
        name.setText(detailGroupSubjects.getDetailTeacher().getNameTeacher());
        phone.setText(detailGroupSubjects.getDetailTeacher().getPhoneTeacher());
        email.setText(detailGroupSubjects.getDetailTeacher().getEmailTeacher());

        groupsDetailAdapter = new GroupsDetailAdapter(getContext(),detailGroupSubjects.getNotification());
        recNotification.setAdapter(groupsDetailAdapter);
        recNotification.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void handleError(Throwable throwable) {
    }

    private void addEvent() {
        btnStudentList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                StudentListFragment fragment = new StudentListFragment();
                Bundle bundle = new Bundle();
                bundle.putString("ID",idGroupSubjects);
                fragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack(null).commit();

            }
        });
    }
}