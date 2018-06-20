package sd.co.uk;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

public class TalkTest {

    Talk talk;
    @Before
    public void setUp() throws Exception {
        talk = new Talk("Title", 60);
    }

    @Test
    public void givenThatNoStartTimeIsSetReturnNull() {
        assertEquals(talk.getStartTime(), null);
    }

    @Test
    public void testToString() {
        LocalTime time = LocalTime.now();
        talk.setStartTime(time);
        String result = talk.toString();
        String expected = time + " Title 60min";

        assertEquals(expected, result);
    }

}
