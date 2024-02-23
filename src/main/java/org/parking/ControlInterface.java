package org.parking;

public interface ControlInterface {
    /**
     * method for simulating car's arriving
     */
    void carArrive();
    /**
     * method for simulating car's departing
     */
    void carDepart();
    /**
     * method for checking current cars on the parking
     */
    void checkCarsOnParking();
}
