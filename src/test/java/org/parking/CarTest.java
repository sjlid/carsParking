package org.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void car_has_nameplate(){
        Nameplate nameplate = new Nameplate("12313");
        Car car = new Car(nameplate);

        assertThat(car.getNamePlate()).isEqualTo("12313");
    }

    @Test
    void there_cannot_be_two_cars_with_equal_nameplate() {
        Nameplate nameplate1 = new Nameplate("123123");
        Nameplate nameplate2 = new Nameplate("123123");
        Car car1 = new Car(nameplate1);
        Car car2 = new Car(nameplate2);

        assertThat(!car1.equals(car2));

    }

}