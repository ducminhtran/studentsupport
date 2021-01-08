package com.meowbeos.studentsupport.model;

import java.util.List;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public class GeneralNews {
    private Category category;
    private List<News> listNews;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<News> getListNews() {
        return listNews;
    }

    public void setListNews(List<News> listNews) {
        this.listNews = listNews;
    }
}
