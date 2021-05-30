package com.example.jdbc.domain;

import java.util.List;

public interface VehicleRepository {

    void saveVehicle(String mark, String model, String color, Integer year);

    List<Vehicle> findAll(Integer minYear, Integer maxYear);

    List<Vehicle> findByYearRange(Integer minYear, Integer maxYear);
}
