package com.meowbeos.studentsupport.model;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public class Schedule {
    private int idSchedule;
    private String lessonsTest;
    private String subjectsName;
    private String classRooms;
    private String classNames;
    private String dateLearn;
    private String timeStart;
    private String lecturersNames;

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public String getLessonsTest() {
        return lessonsTest;
    }

    public void setLessonsTest(String lessonsTest) {
        this.lessonsTest = lessonsTest;
    }

    public String getSubjectsName() {
        return subjectsName;
    }

    public void setSubjectsName(String subjectsName) {
        this.subjectsName = subjectsName;
    }

    public String getClassRooms() {
        return classRooms;
    }

    public void setClassRooms(String classRooms) {
        this.classRooms = classRooms;
    }

    public String getClassNames() {
        return classNames;
    }

    public void setClassNames(String classNames) {
        this.classNames = classNames;
    }

    public String getDateLearn() {
        return dateLearn;
    }

    public void setDateLearn(String dateLearn) {
        this.dateLearn = dateLearn;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getLecturersNames() {
        return lecturersNames;
    }

    public void setLecturersNames(String lecturersNames) {
        this.lecturersNames = lecturersNames;
    }
}
