package org.parking;

import org.junit.jupiter.api.Test;
import org.parking.model.Car;
import org.parking.model.Nameplate;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void car_has_nameplate(){
        Nameplate nameplate = new Nameplate("12313");
        Car car = new Car(nameplate);

        assertThat(car.getNamePlate()).isEqualTo("12313");
    }

}