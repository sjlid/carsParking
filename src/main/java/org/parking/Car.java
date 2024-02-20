package org.parking;

public class Car {
    /**
     * так регистрируется в системе госномер, который прилетает с камеры шлагбаума
     */
    private String plateNumber;
    /**
     * время начала парковки в минутах
     */
    private long parkingStartTime;
    /**
     * время конца парковки в минутах
     */
    private long parkingEndTime;

    public Car(String plateNumber, long parkingStartTime) {
        this.plateNumber = plateNumber;
        this.parkingStartTime = parkingStartTime;
    }
    public String getPlateNumber() {
        return plateNumber;
    }
    public long getParkingStartTime() {
        return parkingStartTime;
    }
    public void setParkingStartTime(long parkingStartTime) {
        this.parkingStartTime = parkingStartTime;
    }
    public long getParkingEndTime() {
        return parkingEndTime;
    }
    public void setParkingEndTime(long parkingEndTime) {
        this.parkingEndTime = parkingEndTime;
    }
}
