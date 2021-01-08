package com.meowbeos.studentsupport.model;

import java.util.List;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public class RegisterCompetition {
    private int idCompetition;
    private int idStudent;
    private List<FieldsRegister> listFields;

    public int getIdCompetition() {
        return idCompetition;
    }

    public void setIdCompetition(int idCompetition) {
        this.idCompetition = idCompetition;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public List<FieldsRegister> getListFields() {
        return listFields;
    }

    public void setListFields(List<FieldsRegister> listFields) {
        this.listFields = listFields;
    }
}
