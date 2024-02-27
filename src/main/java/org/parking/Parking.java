package org.parking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parking {
    private final Map<String, Car> carsOnParking = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Calculates total sum for car's parking in the end of it
     */
    public int calculatePayment(Car car) {
        float totalTime = (float) ((car.getParkingEndTime() - car.getParkingStartTime()) / 60000L);
        return (int) totalTime * (getPayment());
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
        System.out.println("Какой там госномер-то?");
        String newCar = scanner.next();
        carsOnParking.put(
                newCar,
                new Car(newCar, System.currentTimeMillis())
        );
        System.out.println("Отлично! Новое авто может быть на подходе.");
    }

    public void carDepart() {
        System.out.println("Какой уезжает госномер?");
        String carNumber = scanner.next();

        if (carsOnParking.containsKey(carNumber)) {
                carsOnParking
                    .get(carNumber)
                    .setParkingEndTime(System.currentTimeMillis());
            float parkingSum = calculatePayment(carsOnParking.get(carNumber));
            System.out.println("Авто под номером " + carNumber + " уехало.");
            System.out.println("Водитель оплатит " + parkingSum + " рублей");
            getCarsOnParking().remove(carNumber);
        } else {
            System.out.println("Что-то напутали с номером машины, такой нет на парковке!");
        }
    }

    public void checkCarsOnParking() {
        if (!getCarsOnParking().isEmpty()) {
            System.out.println("Сейчас на парковке:");
            System.out.println(carsOnParking.values());
        } else {
            System.out.println("Парковка пуста!");
        }
    }
}
