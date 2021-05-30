package com.example.jdbc.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.StringJoiner;

public class Vehicle {
    private long id;
    @NotBlank(message = "Podaj markę pojazdu!")
    private String mark;
    @NotBlank(message = "Podaj model!")
    private String model;
    @NotBlank(message = "Podaj kolor!")
    private String color;
    @NotNull(message = "Podaj rok produkcji!")
    private Integer year;

    public Vehicle(String mark, String model, String color, Integer year) {
        this.mark = mark;
        this.model = model;
        this.color = color;
        this.year = year;
    }

    public Vehicle() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vehicle.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("mark='" + mark + "'")
                .add("model='" + model + "'")
                .add("color=" + color)
                .add("year=" + year)
                .toString();
    }
}
