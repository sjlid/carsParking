import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.parking.Parking;

class TestParkingApp {
    private static Parking parking;

    @BeforeAll
    static void setUp() {
        parking = new Parking();
    }

    @Test
    @DisplayName("Добавление авто в паркинг")
    void carAddToParking() {
        parking.carArrive();
    }

    @Test
    @DisplayName("Просмотр текущих авто в паркинге")
    void currentCatsOnParking() {
        //
    }

    @Test
    @DisplayName("Удаление авто из паркинга")
    void carRemoveFromParking() {
        //
    }
}
