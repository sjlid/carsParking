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
                    System.out.println("What's the nameplate here, bro? It should be not less than 5 characters and no more than 9 characters");
                    parking.carArrive(scanner.next());
                    continue;
                case "depart":
                    if (!parking.getCarsOnParking().isEmpty()) {
                        System.out.println("What nameplate are leaving us, man?");
                        parking.carDepart(scanner.next());
                        continue;
                    } else {
                        System.out.println("There aren't ANY cars on the parking!");
                        continue;
                    }
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