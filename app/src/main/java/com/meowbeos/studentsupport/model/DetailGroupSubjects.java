package com.meowbeos.studentsupport.model;

import java.util.List;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public class DetailGroupSubjects {
    private int idGroupSubjects;
    private Teacher detailTeacher;
    private List<Notification> notification;

    public int getIdGroupSubjects() {
        return idGroupSubjects;
    }

    public void setIdGroupSubjects(int idGroupSubjects) {
        this.idGroupSubjects = idGroupSubjects;
    }

    public Teacher getDetailTeacher() {
        return detailTeacher;
    }

    public void setDetailTeacher(Teacher detailTeacher) {
        this.detailTeacher = detailTeacher;
    }

    public List<Notification> getNotification() {
        return notification;
    }

    public void setNotification(List<Notification> notification) {
        this.notification = notification;
    }
}
