package org.parking;

import java.time.LocalDateTime;
import java.util.Objects;

public class Car {
    private final String namePlate;
    private final LocalDateTime startTimer;

    public Car(String namePlate) {
        this.namePlate = namePlate;
        startTimer = LocalDateTime.now();
    }

    public LocalDateTime getStartTimer() {
        return startTimer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return Objects.equals(namePlate, car.namePlate);
    }

    @Override
    public int hashCode() {
        return namePlate != null ? namePlate.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Car with " + namePlate + " nameplate";
    }
}
