package org.parking;

import java.util.Objects;

public class Car {
    private final String namePlate;
    private final long parkingStartTime;
    private long parkingEndTime;

    public Car(String namePlate, long parkingStartTime) {
        this.parkingStartTime = parkingStartTime;
        this.namePlate = namePlate;
    }
    public long getParkingStartTime() {
        return parkingStartTime;
    }
    public long getParkingEndTime() {
        return parkingEndTime;
    }
    public void setParkingEndTime(long parkingEndTime) {
        this.parkingEndTime = parkingEndTime;
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
