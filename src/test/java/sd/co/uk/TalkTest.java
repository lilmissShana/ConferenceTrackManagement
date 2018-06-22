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

    // TODO: these kinds of invariant test are good (and nice title) but we should really set up the class hierarchy so that this can't happen (see comments on the talk class)
    @Test
    public void givenThatNoStartTimeIsSetReturnNull() {
        assertEquals(talk.getStartTime(), null);
    }

    // TODO: it's remove this - it's over the top
    @Test
    public void testToString() {
        LocalTime time = LocalTime.now();
        talk.setStartTime(time);
        String result = talk.toString();
        String expected = time + " Title 60min";

        assertEquals(expected, result);
    }

}
