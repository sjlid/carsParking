package org.parking;

public class Nameplate {
    private String namePlate;

    public Nameplate(String namePlate) {
        if (namePlate.length() >= 5 && namePlate.length() <= 9 && namePlate.matches("[a-zA-Z0-9]*")) {
            this.namePlate = namePlate;
        } else {
            throw new IllegalArgumentException("No way! Wrong nameplate!");
        }
    }

    public String getNamePlate() {
        return namePlate;
    }
}
