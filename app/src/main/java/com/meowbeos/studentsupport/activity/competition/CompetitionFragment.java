package com.meowbeos.studentsupport.activity.competition;

import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.meowbeos.studentsupport.R;
import com.meowbeos.studentsupport.adapter.competition.CompetitionAdapter;
import com.meowbeos.studentsupport.constants.STConstant;
import com.meowbeos.studentsupport.model.Competition;
import com.meowbeos.studentsupport.service.ServiceAPI;
import com.meowbeos.studentsupport.utils.StringUtil;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CompetitionFragment extends Fragment {

    private static final String TAG = "Competition";
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ConstraintLayout constraintLayout;

    View view;
    RecyclerView recCompetition;
    CompetitionAdapter competitionAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_competition, container, false);

        initComponent();
        getListCompetition(StringUtil.generateAPIKey());
        return view;
    }



    private void initComponent() {
        constraintLayout = view.findViewById(R.id.constraint_layout);
        recCompetition = view.findViewById(R.id.recCompetition);
    }

    private void getListCompetition(String apiKey) {
        ServiceAPI serviceAPI = new Retrofit.Builder()
                .baseUrl(STConstant.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ServiceAPI.class);

        compositeDisposable.add(serviceAPI.getListCompetition(apiKey)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        );
    }



    private void handleResponse(List<Competition> competitions) {
        competitionAdapter = new CompetitionAdapter(getContext(),competitions);
        recCompetition.setAdapter(competitionAdapter);
        recCompetition.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void handleError(Throwable throwable) {
        Log.e(TAG, "handleError: Error", throwable);
        showError(throwable);
    }

    private void showError(Throwable e) {
        String message = "";
        try {
            if (e instanceof IOException) {
                message = "Không có kết nối Internet!";
            } else if (e instanceof HttpException) {
                HttpException error = (HttpException) e;
                String errorBody = error.response().errorBody().string();
                JSONObject jObj = new JSONObject(errorBody);

                message = jObj.getString("error");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        if (TextUtils.isEmpty(message)) {
            message = "Xảy ra lỗi không xác định được! Kiểm tra LogCat.";
        }

        Snackbar snackbar = Snackbar
                .make(constraintLayout, message, Snackbar.LENGTH_LONG);

        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.dispose();
    }
}