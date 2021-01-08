package com.meowbeos.studentsupport.activity.groupsubjects;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.meowbeos.studentsupport.R;
import com.meowbeos.studentsupport.adapter.groupsubjects.GroupsAdapter;
import com.meowbeos.studentsupport.constants.STConstant;
import com.meowbeos.studentsupport.model.GroupSubjects;
import com.meowbeos.studentsupport.service.ServiceAPI;
import com.meowbeos.studentsupport.utils.StringUtil;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GroupsFragment extends Fragment {

    private static final String TAG = "Groups";
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ConstraintLayout constraintLayout;

    View view;
    RecyclerView recGroups;
    GroupsAdapter groupsAdapter;

    String idStudent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_groups, container, false);

        initComponent();
        setData();
        getListGroupSubjects(StringUtil.generateAPIKey(), idStudent);
        return view;
    }

    private void initComponent() {
        constraintLayout = view.findViewById(R.id.constraint_layout);
        recGroups = view.findViewById(R.id.recGroups);
    }

    private void setData() {
        Bundle bundle = this.getArguments();
        idStudent = bundle.getString("studentID");
    }

    private void getListGroupSubjects(String apiKey, String idStudent) {
        ServiceAPI serviceAPI = new Retrofit.Builder()
                .baseUrl(STConstant.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ServiceAPI.class);

        compositeDisposable.add(serviceAPI.getListGroupSubjects(apiKey, idStudent)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        );
    }

    private void handleResponse(List<GroupSubjects> groupSubjects) {
        groupsAdapter = new GroupsAdapter(getContext(), groupSubjects);
        recGroups.setAdapter(groupsAdapter);
        recGroups.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void handleError(Throwable throwable) {
    }
}