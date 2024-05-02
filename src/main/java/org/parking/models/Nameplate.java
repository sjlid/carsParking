package org.parking.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Embeddable
public class Nameplate {

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 5, max = 9, message = "Nameplate should be between 5 and 9 characters")
    @Pattern(regexp = "[a-zA-Z0-9]$", message = "Nameplate should contain only letters and digits")
    private final String namePlate;

    public Nameplate(String namePlate) {
        if (namePlate.matches("^[a-zA-Z0-9]{5,9}$")) {
            this.namePlate = namePlate;
        } else {
            throw new IllegalArgumentException("No way! Wrong nameplate!");
        }
    }

    public String getNamePlate() {
        return namePlate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nameplate nameplate = (Nameplate) o;

        return namePlate.equals(nameplate.namePlate);
    }

    @Override
    public int hashCode() {
        return namePlate.hashCode();
    }
}
