package org.parking;

public class Car {
    /**
     * parking start time
     */
    private final long parkingStartTime;
    /**
     * parking finish time
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
