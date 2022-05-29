package ru.appline.logic;

import java.util.*;
import java.io.Serializable;

public class SideModel implements Serializable {
    private static final SideModel instance = new SideModel();

    private final Set<Side> model;

    public SideModel() {
        model = new HashSet<>();
    }

    public static SideModel getInstance() {
        return instance;
    }

    public void add(Map<String, String> compassSide) {
        compassSide.forEach((side, degree) -> {
            String[] arrayDegree = degree.split("-");
            double leftBorder = Double.parseDouble(arrayDegree[0]);
            double rightBorder = Double.parseDouble(arrayDegree[1]);

            Side newSide = new Side(side, leftBorder, rightBorder);
            model.add(newSide);
        });
    }

    public String getSide(int value) {
        String nameSide = model.stream().filter(degree -> {
            boolean isNorthSide = (value >= degree.getLeftBorder()) && (value <= 360) ||
                    (value >= 0) && (value <= degree.getRightBorder());

            boolean isSide = (value >= degree.getLeftBorder()) &&
                            (value <= degree.getRightBorder());

            if (isNorthSide) {
                boolean isNorth = degree.getName().equalsIgnoreCase("North");

                if (isNorth) {
                    return true;
                } else if (isSide) {
                    return true;
                } else {
                    return false;
                }
            } else if (isSide) {
               return true;
            } else {
                return false;
            }
        }).findFirst()
                .get()
                .getName();

        return  "{\n\"Side\" : \"" + nameSide + "\"\n}";
    }
}
