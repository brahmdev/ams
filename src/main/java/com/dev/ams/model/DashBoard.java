package com.dev.ams.model;

import java.util.List;

public class DashBoard {

    private List<PieData> pieDataList;
    private List<Standard> standardList;

    public DashBoard() {
    }

    public DashBoard(List<PieData> pieDataList) {
        this.pieDataList = pieDataList;
    }

    public List<PieData> getPieDataList() {
        return pieDataList;
    }

    public void setPieDataList(List<PieData> pieDataList) {
        this.pieDataList = pieDataList;
    }

    public List<Standard> getStandardList() {
        return standardList;
    }

    public void setStandardList(List<Standard> standardList) {
        this.standardList = standardList;
    }

}
