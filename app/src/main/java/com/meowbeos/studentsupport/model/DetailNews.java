package com.meowbeos.studentsupport.model;

import java.util.List;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public class DetailNews {
    private News itemNews;
    private List<News> similarNews;

    public News getItemNews() {
        return itemNews;
    }

    public void setItemNews(News itemNews) {
        this.itemNews = itemNews;
    }

    public List<News> getSimilarNews() {
        return similarNews;
    }

    public void setSimilarNews(List<News> similarNews) {
        this.similarNews = similarNews;
    }
}
