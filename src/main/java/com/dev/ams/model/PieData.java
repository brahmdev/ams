package com.dev.ams.model;

public class PieData {

    private String name;
    private int studentCount;
    private String legendFontColor;
    private String legendFontSize;
    private String color;

    public PieData() {
    }

    public PieData(String name, int studentCount, String legendFontColor, String legendFontSize, String color) {
        this.name = name;
        this.studentCount = studentCount;
        this.legendFontColor = legendFontColor;
        this.legendFontSize = legendFontSize;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public String getLegendFontColor() {
        return legendFontColor;
    }

    public void setLegendFontColor(String legendFontColor) {
        this.legendFontColor = legendFontColor;
    }

    public String getLegendFontSize() {
        return legendFontSize;
    }

    public void setLegendFontSize(String legendFontSize) {
        this.legendFontSize = legendFontSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
