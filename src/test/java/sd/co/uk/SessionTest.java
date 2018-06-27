package sd.co.uk;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

public class SessionTest {

    Session session;

    @Before
    public void setUp() throws Exception {

        Talk t1 = new Talk("talk1", 120);
        Talk t2 = new Talk("talk2", 60);

        LocalTime m_start_time = LocalTime.parse("09:00");
        session = new Session(m_start_time);
        session.getTalkList().add(t1);
        session.getTalkList().add(t2);
    }


    // TODO: add lots more invariant tests - but make sure not to test Talks as they are tested in the TalkTest class.  Try and think about what a session can and can't be, but stick to what the code needs to do - don't add things you don't need

    @Test
    public void testGetSessionLength() {
        double actualTime = session.getSessionLength();
        double expectedTime = 0;

        for (Talk t : session.getTalkList()) {
            expectedTime += t.getLength();
        }
        assertEquals(expectedTime, actualTime, 0.1);
    }

}
