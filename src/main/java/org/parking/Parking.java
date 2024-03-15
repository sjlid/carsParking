package org.parking;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Parking {
    private final Map<String, Car> carsOnParking = new HashMap<>();
    private static final int PARKING_SIZE = 5;

    /**
     * Calculates total sum for car's parking in the end of it
     */
    public int calculatePayment(Car car) {
        LocalDateTime endTimer = LocalDateTime.now();
        Duration totalMinutes = Duration.between(car.getStartTimer(), endTimer);
        return  totalMinutes.toMinutesPart() * getPayment();
    }
    public int getPayment() {
        return 1;
    }
    public Map<String, Car> getCarsOnParking() {
        return carsOnParking;
    }

    public void carArrive(String nameplate) {
        Car car = new Car(new Nameplate(nameplate));
        if (carsOnParking.size() < PARKING_SIZE) {
            carsOnParking.put(nameplate, car);
            System.out.println("Cool! A new auto may arrives in the nearest minute.");
        } else {
            System.out.println("No way! No free space!");
        }
    }

    public void carDepart(String nameplate) {
        if (carsOnParking.containsKey(nameplate)) {
            float parkingSum = calculatePayment(carsOnParking.get(nameplate));
            System.out.println("Car with " + nameplate + "  nameplate has departed.");
            System.out.println("Payment will be " + parkingSum + " rubles");
            getCarsOnParking().remove(nameplate);
        } else {
            System.out.println("Man! We haven't any car with this nameplate.");
        }
    }

    public void checkCarsOnParking() {
        if (!getCarsOnParking().isEmpty()) {
            System.out.println("Currently on the parking: ");
            System.out.println(carsOnParking.keySet());
        } else {
            System.out.println("Parking is free, we haven't any cars here.");
        }
    }
}
