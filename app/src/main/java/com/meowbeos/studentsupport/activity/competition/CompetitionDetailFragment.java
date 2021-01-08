package com.meowbeos.studentsupport.activity.competition;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.meowbeos.studentsupport.R;
import com.meowbeos.studentsupport.constants.STConstant;
import com.meowbeos.studentsupport.model.Competition;
import com.meowbeos.studentsupport.service.ServiceAPI;
import com.meowbeos.studentsupport.utils.StringUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CompetitionDetailFragment extends Fragment {

    private static final String TAG = "CompetitionDetail";
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ConstraintLayout constraintLayout;



    View view;
    TextView title, content, datePost;
    ImageView img;
    Button btnRegisterCompetition;
    String idCompetition;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_competition_detail, container, false);

        initComponent();
        setData();
        getDetailCompetition(StringUtil.generateAPIKey(),idCompetition);

        return  view;
    }

    private void initComponent() {
        title = view.findViewById(R.id.txtTitleCompetitionDetail);
        content = view.findViewById(R.id.txtContentCompetitionDetail);
        datePost = view.findViewById(R.id.txtDatePostCompetitionDetail);
        img = view.findViewById(R.id.imgCompetitionDetail);
        btnRegisterCompetition = view.findViewById(R.id.btnRegisterCompetiton);
    }

    private void setData() {
        Bundle bundle = this.getArguments();
        idCompetition = bundle.getString("ID");
    }

    private void getDetailCompetition(String apiKey, String idCompetition) {
        ServiceAPI serviceAPI = new Retrofit.Builder()
                .baseUrl(STConstant.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ServiceAPI.class);

        compositeDisposable.add(serviceAPI.detailCompetition(apiKey,idCompetition)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        );
    }

    private void handleResponse(Competition competition) {
        title.setText(competition.getTitleCompetition());
        content.setText(competition.getContentCompetition());
        datePost.setText(competition.getDatePost());
    }

    private void handleError(Throwable throwable) {
    }
}