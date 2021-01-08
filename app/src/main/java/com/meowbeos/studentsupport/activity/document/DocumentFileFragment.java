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
import com.meowbeos.studentsupport.adapter.document.DocumentFileAdapter;
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


public class DocumentFileFragment extends Fragment {

    private static final String TAG = "DocumentFile";
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ConstraintLayout constraintLayout;

    View view;
    RecyclerView recDocumentFile;
    DocumentFileAdapter documentFileAdapter;
    String iddocument;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_document_file, container, false);

        initComponent();
        setData();
        getListDocumentFile(StringUtil.generateAPIKey(),iddocument);
        return view;
    }

    private void initComponent() {
        constraintLayout = view.findViewById(R.id.constraint_layout);
        recDocumentFile = view.findViewById(R.id.recDocumentFile);
    }

    private void setData() {
        Bundle bundle = this.getArguments();
        iddocument = bundle.getString("ID");
    }

    private void getListDocumentFile(String apiKey, String iddocument) {
        ServiceAPI serviceAPI = new Retrofit.Builder()
                .baseUrl(STConstant.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ServiceAPI.class);

        compositeDisposable.add(serviceAPI.getListDocumentFile(apiKey,iddocument)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        );
    }

    private void handleResponse(List<Document> documents) {
        documentFileAdapter = new DocumentFileAdapter(getContext(),documents);
        recDocumentFile.setAdapter(documentFileAdapter);
        recDocumentFile.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void handleError(Throwable throwable) {
    }
}