import com.barclays.Car;
import com.barclays.Parking;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingOwnerTest {


    @Test
    public void shouldShowParkingFullIfNotified() throws Exception {
        Parking parking = new Parking(1);
        Car first=new Car("MH10B2568");
        parking.park(first);

    }

    @Test
    public void shouldShowParkingAvailableNotification() throws Exception {

    }
}