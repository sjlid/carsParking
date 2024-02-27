package org.parking;

public class ControlSystem {
    private final Parking parking = new Parking();

    public void manageApp() {
        System.out.println("Приложение поддерживает варианты ввода: приезжает, уезжает, состояние, выход");
        while (true) {
            System.out.println("Приезжает или уезжает авто?");
            String userInput = parking
                    .getScanner()
                    .next();

            switch (userInput) {
                case "приезжает":
                    parking.carArrive();
                    continue;
                case "уезжает":
                    if (!parking
                            .getCarsOnParking()
                            .isEmpty()) {
                        parking.carDepart();
                    } else {
                        System.out.println("У вас нет авто на парковке! Чему там уезжать-то, ты, пес?!");
                    }
                    continue;
                case "состояние":
                    parking.checkCarsOnParking();
                    continue;
                case "выход":
                    return;
                default:
                    System.out.println("Какую-то дичь пишете...");
            }
        }
    }
}