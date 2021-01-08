package com.meowbeos.studentsupport.model;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public class Document {
    private int idDocument;
    private String urlIcon;
    private String summaryDocument;

    public int getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }

    public String getUrlIcon() {
        return urlIcon;
    }

    public void setUrlIcon(String urlIcon) {
        this.urlIcon = urlIcon;
    }

    public String getSummaryDocument() {
        return summaryDocument;
    }

    public void setSummaryDocument(String summaryDocument) {
        this.summaryDocument = summaryDocument;
    }
}
