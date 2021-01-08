package com.meowbeos.studentsupport.model;

import java.util.List;

/**
 * Project name: StudentSupport
 * Created by MeowBeos
 * Date: 26/12/2020
 */

public class RouteBus {
    private int r;
    private String rN;
    private String rNo;
    private List<DetailBus> arrs;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public String getrN() {
        return rN;
    }

    public void setrN(String rN) {
        this.rN = rN;
    }

    public String getrNo() {
        return rNo;
    }

    public void setrNo(String rNo) {
        this.rNo = rNo;
    }

    public List<DetailBus> getArrs() {
        return arrs;
    }

    public void setArrs(List<DetailBus> arrs) {
        this.arrs = arrs;
    }
}
