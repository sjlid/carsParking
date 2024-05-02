package org.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameplateTest {


    @Test
    void length_of_nameplate_should_be_between_5_and_9(){
        Nameplate nameplate = new Nameplate("213ew");

        assertThat(nameplate.getNamePlate()).isEqualTo("213ew");
    }

    @Test
    void nameplate_length_cannot_be_less_than_5() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Nameplate("123a"));
    }

    @Test
    void nameplate_length_cannot_be_more_than_9() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Nameplate("1as23265523a"));
    }

    @Test
    void nameplate_should_contain_only_digits_and_letters() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Nameplate("@ad432"));
    }

    @Test
    void nameplate_should_not_be_empty() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Nameplate(""));
    }

}