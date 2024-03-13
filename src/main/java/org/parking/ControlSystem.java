package org.parking;

public class ControlSystem {
    private final Parking parking;
    private Car car;

    public ControlSystem(Parking parking) {
        this.parking = parking;
    }

    public void manageApp() {
        System.out.println("The app maintain the following commands: arrive, depart, parking, exit.");
        while (true) {
            System.out.println("Is it arriving or departing?");
            String userInput = parking
                    .getScanner()
                    .next();

            switch (userInput) {
                case "arrive":
                    System.out.println("What's the nameplate here, bro? It should be not less than 5 characters and no more than 9 characters");
                    parking.carArrive(car);
                    continue;
                case "depart":
                    if (!parking
                            .getCarsOnParking()
                            .isEmpty()) {
                        parking.carDepart();
                    } else {
                        System.out.println("We haven't ANY cars on our parking, man! Are you blind, cyka blyat?");
                    }
                    continue;
                case "parking":
                    parking.checkCarsOnParking();
                    continue;
                case "exit":
                    return;
                default:
                    System.out.println("What the dich are you writing...");
            }
        }
    }
}