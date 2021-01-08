package com.meowbeos.studentsupport.model;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public class EnrollCancel {
    private int typeEnrollCancel;
    private int idEnrollClass;
    private int idStudent;

    public int getTypeEnrollCancel() {
        return typeEnrollCancel;
    }

    public void setTypeEnrollCancel(int typeEnrollCancel) {
        this.typeEnrollCancel = typeEnrollCancel;
    }

    public int getIdEnrollClass() {
        return idEnrollClass;
    }

    public void setIdEnrollClass(int idEnrollClass) {
        this.idEnrollClass = idEnrollClass;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }
}
