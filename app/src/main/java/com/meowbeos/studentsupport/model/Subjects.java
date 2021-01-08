package com.meowbeos.studentsupport.model;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public class Subjects {
    private int idSubjects;
    private String nameSubjects;
    private String nameClass;
    private String numberCredits;
    private String midtermMarks;
    private String endtermMarks;
    private String nameTeacher;

    public int getIdSubjects() {
        return idSubjects;
    }

    public void setIdSubjects(int idSubjects) {
        this.idSubjects = idSubjects;
    }

    public String getNameSubjects() {
        return nameSubjects;
    }

    public void setNameSubjects(String nameSubjects) {
        this.nameSubjects = nameSubjects;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getNumberCredits() {
        return numberCredits;
    }

    public void setNumberCredits(String numberCredits) {
        this.numberCredits = numberCredits;
    }

    public String getMidtermMarks() {
        return midtermMarks;
    }

    public void setMidtermMarks(String midtermMarks) {
        this.midtermMarks = midtermMarks;
    }

    public String getEndtermMarks() {
        return endtermMarks;
    }

    public void setEndtermMarks(String endtermMarks) {
        this.endtermMarks = endtermMarks;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }
}
