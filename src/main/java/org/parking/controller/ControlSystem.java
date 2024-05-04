package org.parking.controller;


import jakarta.validation.Valid;
import org.parking.dao.ParkingDAO;
import org.parking.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("cars", parkingDAO.carsOnParking());
        return "parking/parked_cars";
    }

    @GetMapping("/menu")
    public String showMenu() {
        return "parking/menu";
    }

    @GetMapping("/arrive")
    public String newCar(Model model) {
        model.addAttribute("car", new Car());
        return "parking/arrive";
    }

    @PostMapping
    public String create(@ModelAttribute("car") @Valid Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "parking/arrive";
        }

        parkingDAO.carArrive(car);
        return "redirect:/parking/menu";
    }

    @GetMapping("/depart")
    public String deleteCar() {
        return "parking/depart";
    }

    @DeleteMapping("/depart")
    public String delete(int id) {
        parkingDAO.carDepart(id);
        return "redirect:/parking/menu";
    }
}