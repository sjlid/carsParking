package org.parking;

import java.util.HashMap;
import java.util.Map;

public class Parking {
    final Map<String, Car> carsOnParking = new HashMap<>();

    /**
     * Calculates total sum for car's parking in the end of it
     */
    public int calculatePayment(long timeStart, long timeFinish) {
        float totalTime = (float) ((timeFinish - timeStart) / 60000L);
        return (int) totalTime * (getPayment());
    }

    public int getPayment() {
        return 1;
    }
}
