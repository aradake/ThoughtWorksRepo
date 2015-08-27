import org.junit.Test;

import static org.junit.Assert.*;

public class DistanceTest {

    @Test
    public void shouldAddDistance()
    {
        Distance first=new Distance(10,50,0);
        Distance second=new Distance(20,300,0);
        Distance result=first.add(second);
        Distance expected=new Distance(30,350,0);
        assertEquals(result,expected);

    }

}