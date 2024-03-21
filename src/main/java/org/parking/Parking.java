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
        return  totalMinutes.toMinutesPart() * getPayment();
    }
    private int getPayment() {
        return parkingCost;
    }
    public Map<String, Car> getCarsOnParking() {
        return Collections.unmodifiableMap(carsOnParking);
    }

    public void carArrive(Car car) {
        if (carsOnParking.size() < parkingSize) {
            if (!carsOnParking.containsKey(car.getNamePlate())) {
                carsOnParking.put(car.getNamePlate(), car);
            } else {
                throw new IllegalArgumentException("Nope! Duplicated nameplate!");
            }
        } else {
            throw new IllegalArgumentException("No way! No free space!");
        }
    }

    public void carDepart(Car car) {
        if (!carsOnParking.isEmpty()) {
            if (carsOnParking.containsKey(car.getNamePlate())) {
                float parkingSum = calculatePayment(carsOnParking.get(car.getNamePlate()));
                System.out.println("Car with " + car.getNamePlate() + " nameplate has departed.");
                System.out.println("Payment will be " + parkingSum + " rubles");
                carsOnParking.remove(car.getNamePlate());
            } else {
                System.out.println("Man! We haven't any car with this nameplate.");
            }
        } else {
            System.out.println("There aren't ANY cars on the parking!");
        }
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
