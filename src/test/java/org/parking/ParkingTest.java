package org.parking;

import org.junit.jupiter.api.Test;
import org.parking.model.Car;
import org.parking.model.Nameplate;
import org.parking.model.Parking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class ParkingTest {


    @Test
    void parking_size_cannot_be_overflowed() {
        Parking parking = new Parking(5,1);

        parking.carArrive(new Car(new Nameplate("11111")));
        parking.carArrive(new Car(new Nameplate("22222")));
        parking.carArrive(new Car(new Nameplate("33333")));
        parking.carArrive(new Car(new Nameplate("44444")));
        parking.carArrive(new Car(new Nameplate("55555")));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> parking.carArrive(new Car(new Nameplate("66666"))));

    }

    @Test
    void there_cannot_be_two_cars_with_same_nameplate() {
        Parking parking = new Parking(5,1);
        parking.carArrive(new Car(new Nameplate("11111")));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> parking.carArrive(new Car(new Nameplate("11111"))));
    }

    @Test
    void parking_contains_all_arrived_cars() {
        Parking parking = new Parking(5,1);
        parking.carArrive(new Car(new Nameplate("11111")));
        parking.carArrive(new Car(new Nameplate("22222")));

        assertThat(parking.getCarsOnParking()).containsAllEntriesOf(parking.getCarsOnParking());

    }
}