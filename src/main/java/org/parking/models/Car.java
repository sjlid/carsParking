package org.parking.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

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

    @Embedded
    @Column(name = "nameplate")
    private String carNameplate;

    public Car() {
    }

    public Car(Nameplate namePlate) {
        this.carNameplate = namePlate.getNamePlate();
        this.startTimer = LocalDateTime.now();
    }

    public LocalDateTime getStartTimer() {
        return startTimer;
    }
    public String getNamePlate() {
        return carNameplate;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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