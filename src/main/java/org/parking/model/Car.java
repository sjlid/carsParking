package org.parking.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Car {
    private final LocalDateTime startTimer;
    private final String carNameplate;

    public Car(Nameplate namePlate) {
        this.carNameplate = namePlate.getNamePlate();
        this.startTimer = LocalDateTime.now();
    }

    public LocalDateTime getStartTimer() {
        return startTimer;
    }
    public String getNamePlate() {
        return carNameplate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return Objects.equals(carNameplate, car.carNameplate);
    }

    @Override
    public int hashCode() {
        return carNameplate != null ? carNameplate.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Car with " + carNameplate + " nameplate";
    }
}