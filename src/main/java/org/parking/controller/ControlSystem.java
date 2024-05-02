package org.parking.controller;

import org.parking.dao.ParkingDAO;
import org.parking.models.Car;
import org.parking.models.Nameplate;
import org.parking.models.Parking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Scanner;

@Controller
@RequestMapping("/parking")
public class ControlSystem {

    private final ParkingDAO parkingDAO;

    @Autowired
    public ControlSystem(ParkingDAO parkingDAO) {
        this.parkingDAO = parkingDAO;
    }


    @GetMapping("/parked_cars")
    public String carsOnParking(Model model) {
        model.addAttribute("parking", parkingDAO.carsOnParking());
        return "parking/parked_cars";
    }


    @GetMapping("/menu")
    public String showMenu() {
        return "parking/menu";
    }

    @GetMapping("/arrive")
    public String arriving() {
        return "parking/arrive";
    }

    @GetMapping("/depart")
    public String departing() {
        return "parking/depart";
    }




    //старый код
    /*
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

     */
}