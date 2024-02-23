package org.parking;

import java.util.Map;
import java.util.Scanner;

public class ControlSystem implements ControlInterface {
    /**
     * boolean variable for avoiding of recursion
     */
    private boolean userCheck = true;
    final Scanner scanner = new Scanner(System.in);
    Parking parking = new Parking();

    public void manageApp() {
        System.out.println("Приложение поддерживает варианты ввода: приезжает, уезжает, состояние, выход");
        while (userCheck) {
            System.out.println("Приезжает или уезжает авто?");
            String userInput = scanner.next();

            switch (userInput) {
                case "приезжает":
                    carArrive();
                    continue;
                case "уезжает":
                    if (!parking.carsOnParking.isEmpty()) {
                        carDepart();
                    } else {
                        System.out.println("У вас нет авто на парковке! Чему там уезжать-то, ты, пес?!");
                    }
                    continue;
                case "состояние":
                    checkCarsOnParking();
                    continue;
                case "выход":
                    userCheck = false;
                    break;
                default:
                    System.out.println("Какую-то дичь пишете...");
            }
        }
    }

    public void carArrive() {
        System.out.println("Какой там госномер-то?");
        String newCar = scanner.next();
        parking.carsOnParking.put(
                newCar,
                new Car(newCar, System.currentTimeMillis())
        );
        System.out.println("Отлично! Новое авто может быть на подходе.");
    }

    public void carDepart() {
        System.out.println("Какой уезжает госномер?");
        String carNumber = scanner.next();

        if (parking.carsOnParking.containsKey(carNumber)) {
            parking.carsOnParking
                    .get(carNumber)
                    .setParkingEndTime(System.currentTimeMillis());
            float parkingSum = parking.calculatePayment(
                    parking.carsOnParking
                            .get(carNumber)
                            .getParkingStartTime(),
                    parking.carsOnParking
                            .get(carNumber)
                            .getParkingEndTime()
            );
            System.out.println("Авто под номером " + carNumber + " уехало.");
            System.out.println("Водитель оплатит " + parkingSum + " рублей");
            parking.carsOnParking.remove(carNumber);
        } else {
            System.out.println("Что-то напутали с номером машины, такой нет на парковке!");
        }
    }

    public void checkCarsOnParking() {
        if (!parking.carsOnParking.isEmpty()) {
            for(Map.Entry<String, Car> entry : parking.carsOnParking.entrySet()) {
                System.out.println(entry.getKey() + " сейчас на парковке");
            }
        } else {
            System.out.println("Парковка пуста!");
        }
    }

}