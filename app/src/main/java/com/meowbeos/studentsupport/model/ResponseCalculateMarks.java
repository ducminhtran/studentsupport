package com.meowbeos.studentsupport.model;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public class ResponseCalculateMarks {
    private String averageFourMarks;
    private String averageTenMarks;
    private String graduationRating;

    public String getAverageFourMarks() {
        return averageFourMarks;
    }

    public void setAverageFourMarks(String averageFourMarks) {
        this.averageFourMarks = averageFourMarks;
    }

    public String getAverageTenMarks() {
        return averageTenMarks;
    }

    public void setAverageTenMarks(String averageTenMarks) {
        this.averageTenMarks = averageTenMarks;
    }

    public String getGraduationRating() {
        return graduationRating;
    }

    public void setGraduationRating(String graduationRating) {
        this.graduationRating = graduationRating;
    }
}
