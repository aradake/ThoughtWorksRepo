import com.barclays.Parking;
import com.barclays.ParkingAttendant;
import com.barclays.ParkingOwner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;



import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ParkingAttendantTest {


    ParkingOwner owner = mock(ParkingOwner.class);


    @Test
    public void shouldAllocateCarParkingToCar() {

        Parking first=mock(Parking.class);
        Parking second=mock(Parking.class);
        owner.addNewParking(first);
        owner.addNewParking(second);

        ParkingAttendant attendant = owner.appointParkingAttendant();

        attendant.assignParkingLots(owner.getParkingList());

        assertSame(Parking.class, attendant.allocateParkingToCar());
    }
}