package com.meowbeos.studentsupport.model;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public class EnrollClass {
    private int idEnrollClass;
    private int statusEnrollClass;
    private int amountEnrollClass;
    private String nameSubjects;
    private int limitEnrollClass;
    private String expirationEnroll;
    private String statusClass;

    public int getIdEnrollClass() {
        return idEnrollClass;
    }

    public void setIdEnrollClass(int idEnrollClass) {
        this.idEnrollClass = idEnrollClass;
    }

    public int getStatusEnrollClass() {
        return statusEnrollClass;
    }

    public void setStatusEnrollClass(int statusEnrollClass) {
        this.statusEnrollClass = statusEnrollClass;
    }

    public int getAmountEnrollClass() {
        return amountEnrollClass;
    }

    public void setAmountEnrollClass(int amountEnrollClass) {
        this.amountEnrollClass = amountEnrollClass;
    }

    public String getNameSubjects() {
        return nameSubjects;
    }

    public void setNameSubjects(String nameSubjects) {
        this.nameSubjects = nameSubjects;
    }

    public int getLimitEnrollClass() {
        return limitEnrollClass;
    }

    public void setLimitEnrollClass(int limitEnrollClass) {
        this.limitEnrollClass = limitEnrollClass;
    }

    public String getExpirationEnroll() {
        return expirationEnroll;
    }

    public void setExpirationEnroll(String expirationEnroll) {
        this.expirationEnroll = expirationEnroll;
    }

    public String getStatusClass() {
        return statusClass;
    }

    public void setStatusClass(String statusClass) {
        this.statusClass = statusClass;
    }
}
