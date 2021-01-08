package com.meowbeos.studentsupport.model;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public class GroupSubjects {
    private int idGroupSubjects;
    private String nameSubjects;
    private String nameTeacher;

    public int getIdGroupSubjects() {
        return idGroupSubjects;
    }

    public void setIdGroupSubjects(int idGroupSubjects) {
        this.idGroupSubjects = idGroupSubjects;
    }

    public String getNameSubjects() {
        return nameSubjects;
    }

    public void setNameSubjects(String nameSubjects) {
        this.nameSubjects = nameSubjects;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }
}
