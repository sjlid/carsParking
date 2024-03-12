package org.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {
    @Test
    void length_of_nameplate_should_be_between_5_and_9(){
        Car car = new Car("213ew");

        assertThat(car.getNamePlate()).isEqualTo("213ew");
    }

    @Test
    void nameplate_length_cannot_be_less_than_5() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car("123a"));
    }

}