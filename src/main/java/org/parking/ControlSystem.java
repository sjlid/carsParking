package org.parking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ControlSystem {
    /**
     * переменная для цикла, чтобы убрать рекурсию
     */
    private boolean userCheck = true;
    /**
     * бахаем хэшмап для хранения тачек
     */
    Map<String, Car> carsOnParking = new HashMap<>();
    /**
     * лоукост замена камере шлагбаума
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * манагер-метод для управления вашей парковочкой
     */
    public void manageApp() {

        while (userCheck) {
            System.out.println("Приезжает или уезжает авто?");
            String userInput = scanner.next();

            switch (userInput) {
                case "приезжает":
                    carArrive();
                    continue;
                case "уезжает":
                    if (!carsOnParking.isEmpty()) {
                        carDepart();
                    } else {
                        System.out.println("У вас нет авто на парковке! Чему там уезжать-то, ты, пес?!");
                    }
                    continue;
                case "состояние":
                    checkCurrentCars();
                    continue;
                case "выход":
                    userCheck = false;
                    break;
                default:
                    System.out.println("Какую-то дичь пишете...");
            }
        }
    }

    /**
     * метод для обработки прибытия авто
     */
    public void carArrive() {
        System.out.println("Какой там госномер-то?");
        String newCar = scanner.next();
        carsOnParking.put(
                newCar,
                new Car(System.currentTimeMillis()                )
        );
        System.out.println("Отлично! Новое авто может быть на подходе.");
    }

    /**
     * метод для обработки уезда авто
     */
    public void carDepart() {
        System.out.println("Какой уезжает госномер?");
        String carNumber = scanner.next();

        if (carsOnParking.containsKey(carNumber)) {
            carsOnParking
                    .get(carNumber)
                    .setParkingEndTime(System.currentTimeMillis());
            checkSum(
                    carsOnParking.get(carNumber).getParkingStartTime(),
                    carsOnParking.get(carNumber).getParkingEndTime()
            );
            System.out.println("Авто под номером " + carNumber + " уехало.");
            carsOnParking.remove(carNumber);
        } else {
            System.out.println("Что-то напутали с номером машины, такой нет на парковке!");
        }
    }

    /**
     * метод для расчета бабла на оплату
     */
    public void checkSum(long timeStart, long timeFinish) {
        float totalTime = (float) ((timeFinish - timeStart) / 60000L);
        float payment = totalTime * (getPayment());
        System.out.println("Водитель заплатит " + payment + " рублей");
    }


    /**
     * это если хотим посмотреть, че там по тачкам, которые ЩАС на парковке.
     * В целом нас интересует только ключ и тачка со своим хэшем
     */
    public void checkCurrentCars() {
        if (!carsOnParking.isEmpty()) {
            for(Map.Entry<String, Car> entry : carsOnParking.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        } else {
            System.out.println("Парковка пуста!");
        }
    }

    /**
     * цена 1 руб / минута
     */
    public int getPayment() {
        return 1;
    }
}