package org.parking;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * реализовываю систему для системы контроля парковки автомоблей на платной стоянке:
 * тачки заезжают под шлагбаум, стоят какое-то время на парковке, потом оплачиваювремя и уезжают
 *  1 час / 60 руб -> 1 минута / 1 рубль
 *  В случае если авто стоит 2.5 часа, то округляется в бОльшую сторону - будет оплата 3 часов
 */

public class ParkingController {
    public static void main(String[] args) {

        ControlSystem controlSystem = new ControlSystem();
        System.out.println("Приложение поддерживает варианты ввода: приезжает, уезжает, состояние, выход");
        controlSystem.manageApp();

        //бимбим бамбам, можете играться

    }
}



class Car {
    private String carId; // так регистрируется в системе госномер, который прилетает с камеры шлагбаума
    private long parkingStartTime; //время начала парковки в минутах
    private long parkingEndTime; //время конца парковки в минутах

    public Car(String carId, long parkingStartTime) {
        this.carId = carId;
        this.parkingStartTime = parkingStartTime;
    }

    public void setId(String carId) {
        this.carId = carId;
    }
    public String getId() {
        return carId;
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

class ControlSystem {

    private final int PAYMENT = 1; //тариф за минуту
    Map<String, Car> carsOnParking = new HashMap<>(); //бахаем хэшмап для хранения тачек
    Scanner scanner = new Scanner(System.in); //лоукост замена камере шлагбаума

    //манагер для управления вашей парковочкой
    public void manageApp() {
        System.out.println("Приезжает или уезжает авто?");
        String userInput = scanner.next();

        switch (userInput) {
            case "приезжает":
                carArrive();
            case "уезжает":
                if (!carsOnParking.isEmpty()) {
                    carDepart();
                } else {
                    System.out.println("У вас нет авто на парковке! Чему там уезжать-то, ты, пес?!");
                    manageApp();
                }
            case "состояние":
                checkCurrentCars();
            case "выход":
                break;
            default:
                System.out.println("Какую-то дичь пишете...");
                manageApp();
        }
    }

    //метод для обработки прибытия авто
    public void carArrive() {
        System.out.println("Какой там госномер-то?"); //инфа с камеры
        String newCar = scanner.next();
        carsOnParking.put(newCar, new Car(newCar, System.currentTimeMillis())); //пиупиу и добавили в мапу
        System.out.println("Отлично! Новое авто может быть на подходе.");
        manageApp();
    }

    //метод для обработки уезда авто
    public void carDepart() {
        System.out.println("Какой уезжает госномер?"); //инфа с камеры
        String carNumber = scanner.next();
        carsOnParking.get(carNumber).setParkingEndTime(System.currentTimeMillis()); // пишем в уезжающую тачку время окончания парковки
        checkSum(carsOnParking.get(carNumber).getParkingStartTime(), carsOnParking.get(carNumber).getParkingEndTime()); //тут считаем бабло
        System.out.println("Авто под номером " + carNumber + " уехало.");
        carsOnParking.remove(carNumber); //выпихиваем из мапы пару
        manageApp();
    }

    //метод для расчета бабла на оплату
    public void checkSum(long timeStart, long timeFinish) {
        float totalTime = (float) ((timeFinish - timeStart) / 60000L); // перевод в минуты и кастим
        float payment = totalTime * (getPayment());
        System.out.println("Водитель заплатит " + payment + " рублей");

    }


    //это если хотим посмотреть, че там по тачкам, которые ЩАС на парковке. В целом нас интересует только ключ и тачка со своим хэшем
    public void checkCurrentCars() {
        if (!carsOnParking.isEmpty()) {
            for(Map.Entry<String, Car> entry : carsOnParking.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        } else {
            System.out.println("Парковка пуста!");
        }
        manageApp();
    }

    public int getPayment() {
        return PAYMENT;
    }
}


