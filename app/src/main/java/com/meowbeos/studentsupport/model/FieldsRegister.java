package com.meowbeos.studentsupport.model;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public class FieldsRegister {
    private int idFields;
    private String nameFields;
    private String typeFields;
    private String requiredFields;
    private String valueFields;

    public int getIdFields() {
        return idFields;
    }

    public void setIdFields(int idFields) {
        this.idFields = idFields;
    }

    public String getNameFields() {
        return nameFields;
    }

    public void setNameFields(String nameFields) {
        this.nameFields = nameFields;
    }

    public String getTypeFields() {
        return typeFields;
    }

    public void setTypeFields(String typeFields) {
        this.typeFields = typeFields;
    }

    public String getRequiredFields() {
        return requiredFields;
    }

    public void setRequiredFields(String requiredFields) {
        this.requiredFields = requiredFields;
    }

    public String getValueFields() {
        return valueFields;
    }

    public void setValueFields(String valueFields) {
        this.valueFields = valueFields;
    }
}
