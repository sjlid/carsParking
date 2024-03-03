package org.parking;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parking {
    private final Map<String, Car> carsOnParking = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
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
    public Scanner getScanner() {
        return scanner;
    }

    public void carArrive() {
        System.out.println("What's the nameplate here, bro? It should be not less than 5 characters and no more than 9 characters");
        String newCar = scanner.next();
        if (carsOnParking.size() < PARKING_SIZE) {
            if (newCar.length() >= 5 && newCar.length() <= 9) {
                carsOnParking.put(newCar, new Car(newCar));
                System.out.println(carsOnParking.size());
                System.out.println("Cool! A new auto may arrives in the nearest minute.");
            } else {
                System.out.println("No way! Wrong nameplate!");
            }
        } else {
            System.out.println("No way! No free space!");
        }
    }

    public void carDepart() {
        if (!carsOnParking.isEmpty()) {
            System.out.println("What nameplate are leaving us, man?");
            String carNumber = scanner.next();
            if (carsOnParking.containsKey(carNumber)) {
                float parkingSum = calculatePayment(carsOnParking.get(carNumber));
                System.out.println("Car with " + carNumber + "  nameplate has departed.");
                System.out.println("Payment will be " + parkingSum + " rubles");
                getCarsOnParking().remove(carNumber);
            } else {
                System.out.println("Dafaq, man!! We haven't any car with this nameplate.");
            }
        } else {
            System.out.println("There aren't ANY cars, biatch, on the parking!");
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
