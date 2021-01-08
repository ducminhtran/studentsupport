package com.meowbeos.studentsupport.model;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

import java.util.List;

public class CalculateMarks {
    private int typeCalculate;
    private List<Marks> listMarks;

    public int getTypeCalculate() {
        return typeCalculate;
    }

    public void setTypeCalculate(int typeCalculate) {
        this.typeCalculate = typeCalculate;
    }

    public List<Marks> getListMarks() {
        return listMarks;
    }

    public void setListMarks(List<Marks> listMarks) {
        this.listMarks = listMarks;
    }
}
