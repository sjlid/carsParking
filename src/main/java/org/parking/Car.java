package org.parking;

public class Car {
    /**
     * время начала парковки в минутах
     */
    private final long parkingStartTime;
    /**
     * время конца парковки в минутах
     */
    private long parkingEndTime;

    public Car(long parkingStartTime) {
        this.parkingStartTime = parkingStartTime;
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
}
