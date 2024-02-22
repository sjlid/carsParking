package org.parking;

/**
 * realizing emulation of app for cars parking system, where
 * cars arrive, depart, and system can calculate the final payment
 * and check current cars on the parking
 */
public class ParkingApplication {
    public static void main(String[] args) {

        ControlSystem controlSystem = new ControlSystem();
        System.out.println("Приложение поддерживает варианты ввода: приезжает, уезжает, состояние, выход");
        controlSystem.manageApp();

        //бимбим бамбам, можете играться

    }
}





