package com.meowbeos.studentsupport.activity.news;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.meowbeos.studentsupport.R;
import com.meowbeos.studentsupport.adapter.news.RelatedNewsAdapter;
import com.meowbeos.studentsupport.constants.STConstant;
import com.meowbeos.studentsupport.model.DetailNews;
import com.meowbeos.studentsupport.service.ServiceAPI;
import com.meowbeos.studentsupport.utils.StringUtil;
import com.squareup.picasso.Picasso;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NewsDetailFragment extends Fragment {

    private static final String TAG = "NewsDetail";
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private ConstraintLayout constraintLayout;

    View view;
    TextView title, content, author, datePost;
    ImageView image;
    RecyclerView recRelatedNews;
    RelatedNewsAdapter relatedNewsAdapter;
    String idNews;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_detail, container, false);

        initComponent();
        setData();
        getDetailNews(StringUtil.generateAPIKey(),idNews);

        return view;
    }
    private void initComponent() {
        constraintLayout = view.findViewById(R.id.constraint_layout);

        title = view.findViewById(R.id.txtTitleNewsDetail);
        content = view.findViewById(R.id.txtContentDetailNews);
        image = view.findViewById(R.id.imgNewsDetail);
        author = view.findViewById(R.id.txtAuthorNewsDetail);
        datePost = view.findViewById(R.id.txtDatePostNewsDetail);
        recRelatedNews = view.findViewById(R.id.recRelatedNews);
    }

    private void setData() {
        Bundle bundle = this.getArguments();
        idNews = bundle.getString("ID");
//        String Title = bundle.getString("Title");
//        String Content = bundle.getString("Content");
//        String Image = bundle.getString("Image");
//        String Author = bundle.getString("Author");
//        String DatePost = bundle.getString("DatePost");

//        title.setText(Title);
//        content.setText(Content);
//        author.setText(Author);
//        datePost.setText(DatePost);
//        Picasso.get().load(Image).error(R.drawable.error).into(image);
    }

    private void getDetailNews(String apiKey, String idNews) {
        ServiceAPI serviceAPI = new Retrofit.Builder()
                .baseUrl(STConstant.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ServiceAPI.class);

        compositeDisposable.add(serviceAPI.detailNews(apiKey,idNews)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
        );
    }

    private void handleError(Throwable throwable) {
    }

    private void handleResponse(DetailNews detailNews) {
        title.setText(detailNews.getItemNews().getTitleNews());
        content.setText(detailNews.getItemNews().getContentNews());
        author.setText(detailNews.getItemNews().getAuthorNews());
        datePost.setText(detailNews.getItemNews().getDatePost());
        Picasso.get().load(detailNews.getItemNews().getUrlBanner()).error(R.drawable.error).into(image);

        relatedNewsAdapter = new RelatedNewsAdapter(getContext(),detailNews);
        recRelatedNews.setAdapter(relatedNewsAdapter);
        recRelatedNews.setLayoutManager(new LinearLayoutManager(getContext()));

    }


}
