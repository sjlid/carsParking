package org.parking;

import java.util.Scanner;

public class ControlSystem {
    private final Parking parking;
    private final Scanner scanner = new Scanner(System.in);

    public ControlSystem(Parking parking) {
        this.parking = parking;
    }

    public void manageApp() {
        System.out.println("The app maintain the following commands: arrive, depart, parking, exit.");
        while (true) {
            System.out.println("Is it arriving or departing?");
            String userInput = scanner.next();
            switch (userInput) {
                case "arrive":
                    parking.carArrive();
                    continue;
                case "depart":
                    parking.carDepart();
                    continue;
                case "parking":
                    parking.checkCarsOnParking();
                    continue;
                case "exit":
                    return;
                default:
                    System.out.println("Ah?! I dunno what is it...");
            }
        }
    }
}