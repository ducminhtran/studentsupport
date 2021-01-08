package com.meowbeos.studentsupport.model;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public class Competition {
    private int idCompetition;
    private String urlBanner;
    private String titleCompetition;
    private String summaryCompetition;
    private String datePost;
    private String contentCompetition;

    public int getIdCompetition() {
        return idCompetition;
    }

    public void setIdCompetition(int idCompetition) {
        this.idCompetition = idCompetition;
    }

    public String getUrlBanner() {
        return urlBanner;
    }

    public void setUrlBanner(String urlBanner) {
        this.urlBanner = urlBanner;
    }

    public String getTitleCompetition() {
        return titleCompetition;
    }

    public void setTitleCompetition(String titleCompetition) {
        this.titleCompetition = titleCompetition;
    }

    public String getSummaryCompetition() {
        return summaryCompetition;
    }

    public void setSummaryCompetition(String summaryCompetition) {
        this.summaryCompetition = summaryCompetition;
    }

    public String getDatePost() {
        return datePost;
    }

    public void setDatePost(String datePost) {
        this.datePost = datePost;
    }

    public String getContentCompetition() {
        return contentCompetition;
    }

    public void setContentCompetition(String contentCompetition) {
        this.contentCompetition = contentCompetition;
    }
}
