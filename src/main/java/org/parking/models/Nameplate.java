package org.parking.models;

public record Nameplate(String namePlate) {

    public Nameplate(String namePlate) {
            this.namePlate = namePlate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nameplate nameplate = (Nameplate) o;

        return namePlate.equals(nameplate.namePlate);
    }

}
