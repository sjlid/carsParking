package org.parking;

/**
 * реализовываю систему для системы контроля парковки автомоблей на платной стоянке:
 * тачки заезжают под шлагбаум, стоят какое-то время на парковке, потом оплачивают время и уезжают
 *  1 час / 60 руб -> 1 минута / 1 рубль
 */
public class ParkingApplication {
    public static void main(String[] args) {

        ControlSystem controlSystem = new ControlSystem();
        System.out.println("Приложение поддерживает варианты ввода: приезжает, уезжает, состояние, выход");
        controlSystem.manageApp();

        //бимбим бамбам, можете играться

    }
}





