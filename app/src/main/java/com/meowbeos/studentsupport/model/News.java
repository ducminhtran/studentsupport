package com.meowbeos.studentsupport.model;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public class News {
    private int idNews;
    private String urlBanner;
    private String titleNews;
    private String summaryNews;
    private String datePost;
    private String authorNews;
    private String contentNews;

    public int getIdNews() {
        return idNews;
    }

    public void setIdNews(int idNews) {
        this.idNews = idNews;
    }

    public String getUrlBanner() {
        return urlBanner;
    }

    public void setUrlBanner(String urlBanner) {
        this.urlBanner = urlBanner;
    }

    public String getTitleNews() {
        return titleNews;
    }

    public void setTitleNews(String titleNews) {
        this.titleNews = titleNews;
    }

    public String getSummaryNews() {
        return summaryNews;
    }

    public void setSummaryNews(String summaryNews) {
        this.summaryNews = summaryNews;
    }

    public String getDatePost() {
        return datePost;
    }

    public void setDatePost(String datePost) {
        this.datePost = datePost;
    }

    public String getAuthorNews() {
        return authorNews;
    }

    public void setAuthorNews(String authorNews) {
        this.authorNews = authorNews;
    }

    public String getContentNews() {
        return contentNews;
    }

    public void setContentNews(String contentNews) {
        this.contentNews = contentNews;
    }
}
