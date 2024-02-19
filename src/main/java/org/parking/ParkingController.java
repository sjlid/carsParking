package org.parking;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * реализовываю систему для системы контроля парковки автомоблей на платной стоянке:
 * тачки заезжают под шлагбаум, стоят какое-то время на парковке, потом оплачиваювремя и уезжают
 *  1 час / 60 руб
 *  3 часа / 150 руб
 *  6 и более / 300 руб
 *  В случае если авто стоит 2.5 часа, то округляется в бОльшую сторону - будет оплата 3 часов
 */

public class ParkingController {
    public static void main(String[] args) {
        ControlSystem controlSystem = new ControlSystem();
        controlSystem.carArrive();
        controlSystem.carArrive();
        controlSystem.carArrive();
        controlSystem.carArrive();


        controlSystem.checkCurrentCars();

        controlSystem.carDepart();

        controlSystem.checkCurrentCars();







    }
}



class Car {
    private String carId; // так регистрируется в системе госномер, который прилетает с камеры шлагбаума
    private long parkingStartTime; //время стоянки в минутах
    private long parkingEndTime;

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

    //бахаем хэшмап для хранения тачек
    Map<String, Car> carsOnParking = new HashMap<>();

    Scanner scanner = new Scanner(System.in); //лоукост замена камере шлагбаума
    int carsCounter = 1; //счетчик для прибывших тачек, будет играть роль ключа для хэшмапы


    public void carArrive() {
        System.out.println("Какой там госномер-то?"); //инфа с камеры
        String newCar = scanner.next();
        carsOnParking.put(newCar, new Car(newCar, System.currentTimeMillis())); //пиупиу и добавили в мапу
        carsCounter++;
        System.out.println("Отлично! Новое авто может быть на подходе.");
    }

    public void carDepart() {
        System.out.println("Какой уезжает госномер?"); //типа инфа с камеры
        String carNumber = scanner.next();
        for (Map.Entry<String, Car> entry : carsOnParking.entrySet()) {
            if (Objects.equals(carNumber, entry.getValue())) {
                carsOnParking.remove(entry);
            }
        }



        System.out.println("Авто под номером " + carNumber + " уехало"); //типа инфа с камеры
    }

    private int checkSum() {
        return 0;
    }


    //это если хотим посмотреть, че там по тачкам, которые ЩАС на парковке
    public void checkCurrentCars() {
        for(Map.Entry<String, Car> entry : carsOnParking.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }


}


