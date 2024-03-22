package org.parking;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Parking {
    private final Map<String, Car> carsOnParking = new HashMap<>();
    private final int parkingSize;
    private final int parkingCost;


    public Parking(int parkingSize, int parkingCost) {
        this.parkingSize = parkingSize;
        this.parkingCost = parkingCost;
    }

    /**
     * Calculates total sum for car's parking in the end of it
     */
    private int calculatePayment(Car car) {
        LocalDateTime endTimer = LocalDateTime.now();
        Duration totalMinutes = Duration.between(car.getStartTimer(), endTimer);
        return totalMinutes.toMinutesPart() * parkingCost;
    }
    public Map<String, Car> getCarsOnParking() {
        return Collections.unmodifiableMap(carsOnParking);
    }

    public void carArrive(Car car) {
        if (carsOnParking.size() >= parkingSize) {
            throw new IllegalArgumentException("No way! No free space!");
        }
        if (carsOnParking.containsKey(car.getNamePlate())) {
            throw new IllegalArgumentException("Nope! Duplicated nameplate!");
        }
        carsOnParking.put(car.getNamePlate(), car);
    }


    public float carDepart(Car car) {
        if (carsOnParking.isEmpty()) {
            throw new IllegalArgumentException("There aren't ANY cars on the parking!");
        }
        if (!carsOnParking.containsKey(car.getNamePlate())) {
            throw new IllegalArgumentException("Man! We haven't any car with this nameplate.");
        }
        float parkingCost = calculatePayment(carsOnParking.get(car.getNamePlate()));
        carsOnParking.remove(car.getNamePlate());
        return parkingCost;
    }


    public void checkCarsOnParking() {
        if (!carsOnParking.isEmpty()) {
            System.out.println("Currently on the parking: ");
            System.out.println(carsOnParking.keySet());
        } else {
            System.out.println("Parking is free, we haven't any cars here.");
        }
    }
}
