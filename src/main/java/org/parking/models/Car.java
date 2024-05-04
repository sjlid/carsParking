package org.parking.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "starttime")
    private LocalDateTime startTimer;

    @NotEmpty(message = "Name should not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9]{5,9}$", message = "Nameplate should contain only letters and digits, and be between 5 and 9 characters")
    @Column(name = "nameplate")
    private String carNameplate;

    public Car() {
    }

    public Car(Nameplate namePlate) {
        this.carNameplate = namePlate.namePlate();
        this.startTimer = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStartTimer() {
        return startTimer;
    }

    public void setStartTimer(LocalDateTime startTimer) {
        this.startTimer = startTimer;
    }

    public String getCarNameplate() {
        return carNameplate;
    }

    public void setCarNameplate(String carNameplate) {
        this.carNameplate = carNameplate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return Objects.equals(carNameplate, car.carNameplate);
    }

    @Override
    public int hashCode() {
        return carNameplate != null ? carNameplate.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Car with " + carNameplate + " nameplate";
    }
}