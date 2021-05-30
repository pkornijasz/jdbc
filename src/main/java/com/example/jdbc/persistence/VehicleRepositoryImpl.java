package com.example.jdbc.persistence;

import com.example.jdbc.domain.Vehicle;
import com.example.jdbc.domain.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public VehicleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveVehicle(String mark, String model, String color, Integer year) {
        String sql = "INSERT INTO vehicles(mark, model, color, year) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql, mark, model, color, year);

    }

    @Override
    public List<Vehicle> findAll(Integer minYear, Integer maxYear) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE year >= ? AND year <= ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, minYear, maxYear);
        maps.forEach(element -> vehicles.add(new Vehicle(
                String.valueOf(element.get("mark")),
                String.valueOf(element.get("model")),
                String.valueOf(element.get("color")),
                Integer.parseInt(String.valueOf(element.get("year")))
        )));
        return vehicles;
    }

    @Override
    public List<Vehicle> findByYearRange(Integer minYear, Integer maxYear) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE year >= ? AND year <= ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, minYear, maxYear);
        maps.forEach(element -> vehicles.add(new Vehicle(
                String.valueOf(element.get("mark")),
                String.valueOf(element.get("model")),
                String.valueOf(element.get("color")),
                Integer.parseInt(String.valueOf(element.get("year")))
        )));
        return vehicles;
    }
}
