package org.parking;

public interface IControl {
    void carArrive();
    void carDepart();
    void checkCurrentCars();
    void checkSum(long timeStart, long timeFinish);
    void manageApp();
}
