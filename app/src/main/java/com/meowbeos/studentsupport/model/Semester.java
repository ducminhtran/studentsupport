package com.meowbeos.studentsupport.model;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public class Semester {
    private int idSemester;
    private String schoolYear;
    private String nameSemester;
    private String dateSemester;

    public int getIdSemester() {
        return idSemester;
    }

    public void setIdSemester(int idSemester) {
        this.idSemester = idSemester;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getNameSemester() {
        return nameSemester;
    }

    public void setNameSemester(String nameSemester) {
        this.nameSemester = nameSemester;
    }

    public String getDateSemester() {
        return dateSemester;
    }

    public void setDateSemester(String dateSemester) {
        this.dateSemester = dateSemester;
    }
}
