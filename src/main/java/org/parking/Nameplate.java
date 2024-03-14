package org.parking;

public record Nameplate(String namePlate) {
    public Nameplate(String namePlate) {
        if (namePlate.length() >= 5 && namePlate.length() <= 9 && namePlate.matches("[a-zA-Z0-9]*")) {
            this.namePlate = namePlate;
        } else {
            throw new IllegalArgumentException("No way! Wrong nameplate!");
        }
    }
}
