package sd.co.uk.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import sd.co.uk.model.Session;
import sd.co.uk.model.Talk;

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
