package com.meowbeos.studentsupport.activity.document;

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
import com.meowbeos.studentsupport.adapter.document.DocumentCategoryAdapter;
import com.meowbeos.studentsupport.constants.STConstant;
import com.meowbeos.studentsupport.model.Document;
import com.meowbeos.studentsupport.service.ServiceAPI;
import com.meowbeos.studentsupport.utils.StringUtil;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DocumentFragment extends Fragment {

    private static final String TAG = "DocumentCategory";
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ConstraintLayout constraintLayout;

    View view;
    RecyclerView recDocumentCategory;
    DocumentCategoryAdapter documentCategoryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_document, container, false);

        initComponent();
        getListDocumentCategory(StringUtil.generateAPIKey());
        return  view;
    }

    private void initComponent() {
        constraintLayout = view.findViewById(R.id.constraint_layout);
        recDocumentCategory = view.findViewById(R.id.recDocumentCategory);
    }

    private void getListDocumentCategory(String apiKey) {
        ServiceAPI serviceAPI = new Retrofit.Builder()
                .baseUrl(STConstant.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ServiceAPI.class);

        compositeDisposable.add(serviceAPI.getListDocumentCategory(apiKey)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        );
    }

    private void handleResponse(List<Document> documents) {
        documentCategoryAdapter = new DocumentCategoryAdapter(getContext(),documents);
        recDocumentCategory.setAdapter(documentCategoryAdapter);
        recDocumentCategory.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void handleError(Throwable throwable) {
    }
}

