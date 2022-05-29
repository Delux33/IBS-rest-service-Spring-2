package ru.appline.logic;

public class Side {
    private String name;
    private double leftBorder;
    private double rightBorder;

    public Side() {

    }

    public Side(String name, double leftBorder, double rightBorder) {
        this.name = name;
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLeftBorder() {
        return leftBorder;
    }

    public void setLeftBorder(double leftBorder) {
        this.leftBorder = leftBorder;
    }

    public double getRightBorder() {
        return rightBorder;
    }

    public void setRightBorder(double rightBorder) {
        this.rightBorder = rightBorder;
    }
}
