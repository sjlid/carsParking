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
                    Car car = new Car(new Nameplate(scanner.next()));
                    parking.carArrive(car);
                    System.out.println("Cool! A new auto may arrives in the nearest minute.");
                    continue;
                case "depart":
                    System.out.println("What nameplate are leaving us, man?");
                    String carDeparting = scanner.next();
                    System.out.println("Payment will be " + parking.carDepart(parking.getCarsOnParking()
                            .get(carDeparting)) + " rubles");
                    System.out.println("Car with " + carDeparting + " nameplate has departed.");
                    continue;
                case "parking":
                    System.out.println("Currently we have the following cars here: \n" + parking.checkCarsOnParking());
                    continue;
                case "exit":
                    return;
                default:
                    System.out.println("Ah?! I dunno what is it...");
            }
        }
    }
}