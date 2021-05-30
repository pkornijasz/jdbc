package com.example.jdbc.web;

import com.example.jdbc.domain.Range;
import com.example.jdbc.domain.Vehicle;
import com.example.jdbc.domain.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class VehicleController {

    private final VehicleRepository repository;

    @Autowired
    public VehicleController(VehicleRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String getAllVehicles(Model model, @RequestParam(required = false) Integer minYear, @RequestParam(required = false) Integer maxYear) {
        if (minYear == null) { minYear = 1900; }
        if (maxYear == null) { maxYear = 2099; }
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.addAll(repository.findAll(minYear, maxYear));
        System.out.println(vehicles);
        model.addAttribute("vehicles", vehicles);
        model.addAttribute("vehicle", new Vehicle());
        model.addAttribute("range", new Range());
        return "vehicles";
    }

    @PostMapping("/save")
    public String saveVehicle(@Valid Vehicle vehicle) {
        repository.saveVehicle(vehicle.getMark(), vehicle.getModel(), vehicle.getColor(), vehicle.getYear());
        return "redirect:/";
    }

}
