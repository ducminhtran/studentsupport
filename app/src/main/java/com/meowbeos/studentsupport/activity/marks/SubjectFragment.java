package com.meowbeos.studentsupport.activity.marks;

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
import com.meowbeos.studentsupport.adapter.marks.SubjectAdapter;
import com.meowbeos.studentsupport.constants.STConstant;
import com.meowbeos.studentsupport.model.Subjects;
import com.meowbeos.studentsupport.service.ServiceAPI;
import com.meowbeos.studentsupport.utils.StringUtil;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SubjectFragment extends Fragment {

    private static final String TAG = "Subject";
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ConstraintLayout constraintLayout;


    View view;
    RecyclerView recSubject;
    SubjectAdapter subjectAdapter;

    String idSemester;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_subject, container, false);

        initComponent();
        setData();
        getListSubjects(StringUtil.generateAPIKey(),idSemester);
        return view;
    }

    private void initComponent() {
        constraintLayout = view.findViewById(R.id.constraint_layout);
        recSubject = view.findViewById(R.id.recSubject);
    }

    private void setData() {
        Bundle bundle = this.getArguments();
        idSemester = bundle.getString("ID");
    }

    private void getListSubjects(String apiKey, String idSemester) {
        ServiceAPI serviceAPI = new Retrofit.Builder()
                .baseUrl(STConstant.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ServiceAPI.class);

        compositeDisposable.add(serviceAPI.getListSubjects(apiKey, idSemester)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        );
    }

    private void handleResponse(List<Subjects> subjects) {
        subjectAdapter = new SubjectAdapter(getContext(),subjects);
        recSubject.setAdapter(subjectAdapter);
        recSubject.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void handleError(Throwable throwable) {

    }
}