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
import com.meowbeos.studentsupport.adapter.groupsubjects.StudentListAdapter;
import com.meowbeos.studentsupport.constants.STConstant;
import com.meowbeos.studentsupport.model.Student;
import com.meowbeos.studentsupport.service.ServiceAPI;
import com.meowbeos.studentsupport.utils.StringUtil;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class StudentListFragment extends Fragment {
    private static final String TAG = "StudentList";
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ConstraintLayout constraintLayout;

    View view;
    RecyclerView recStudentList;
   StudentListAdapter studentListAdapter;

    String idGroupSubjects;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_student_list, container, false);

        initComponent();
        setData();
        getListStudentGroup(StringUtil.generateAPIKey(),idGroupSubjects);

        return view;
    }

    private void initComponent() {
        recStudentList = view.findViewById(R.id.recStudentList);
    }

    private void setData() {
        Bundle bundle = this.getArguments();
        idGroupSubjects = bundle.getString("ID");
    }

    private void getListStudentGroup(String apiKey, String idGroupSubjects) {
        ServiceAPI serviceAPI = new Retrofit.Builder()
                .baseUrl(STConstant.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ServiceAPI.class);

        compositeDisposable.add(serviceAPI.getListStudentGroup(apiKey,idGroupSubjects)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        );
    }

    private void handleResponse(List<Student> students) {
        studentListAdapter = new StudentListAdapter(getContext(),students);
        recStudentList.setAdapter(studentListAdapter);
        recStudentList.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    private void handleError(Throwable throwable) {

    }
}