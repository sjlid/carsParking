package org.parking.controller;


import jakarta.validation.Valid;
import org.parking.dao.CarDAO;
import org.parking.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/parking")
public class ControlSystem {

    private final CarDAO carDAO;

    @Autowired
    public ControlSystem(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping("/parked_cars")
    public String carsOnParking(Model model) {
        model.addAttribute("cars", carDAO.carsOnParking());
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
        carDAO.carArrive(car);
        return "redirect:/parking/menu";
    }

    @GetMapping("/{id}")
    public String showCar(@PathVariable("id") int id, Model model) {
        model.addAttribute("car", carDAO.showCar(id));
        return "parking/show_car";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        carDAO.carDepart(id);
        return "redirect:/parking/menu";
    }
}