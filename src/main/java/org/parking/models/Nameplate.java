package org.parking.models;

public class Nameplate {
    private final String namePlate;

    public Nameplate(String namePlate) {
        if (namePlate.matches("^[a-zA-Z0-9]{5,9}$")) {
            this.namePlate = namePlate;
        } else {
            throw new IllegalArgumentException("No way! Wrong nameplate!");
        }
    }

    public String getNamePlate() {
        return namePlate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nameplate nameplate = (Nameplate) o;

        return namePlate.equals(nameplate.namePlate);
    }

    @Override
    public int hashCode() {
        return namePlate.hashCode();
    }
}
