package test.java;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import main.java.Session;
import main.java.Talk;
import main.java.Track;

public class TrackTest {

    Track track;
    Session morningSession;
    Session afternoonSession;

    @Before
    public void setUp() throws Exception {
        Talk t1 = new Talk("talk1", 120);
        Talk t2 = new Talk("talk2", 60);
        Talk t3 = new Talk("talk3", 115);
        Talk t4 = new Talk("talk4", 60);
        Talk t5 = new Talk("talk5", 5);
        Talk t6 = new Talk("talk6", 5);
        LocalTime m_start_time = LocalTime.parse("09:00");
        LocalTime a_start_time = LocalTime.parse("13:00");

        LocalTime lunch_start_time = LocalTime.parse("12:00");
        

        morningSession = new Session(m_start_time);
        morningSession.getTalkList().add(t1);
        morningSession.getTalkList().add(t2);

        afternoonSession = new Session(a_start_time);
        afternoonSession.getTalkList().add(t3);
        afternoonSession.getTalkList().add(t4);
        afternoonSession.getTalkList().add(t5);
        afternoonSession.getTalkList().add(t6);

        track = new Track("Track 1", morningSession, afternoonSession, lunch_start_time);

    }


    @Test
    public void testGetMorning_session() {
        assertEquals(true, track.getMorning_session().equals(morningSession));
    }

    @Test
    public void testGetAfternoon_session() {
        assertEquals(true, track.getAfternoon_session().equals(afternoonSession));
    }

    @Test
    public void testGetTotalTalkTime() {
        double actualTime = track.getTotalTalkTime();
        double expectedTime = 0;

        for (Talk t : track.getAfternoon_session().getTalkList()) {
            expectedTime += t.getLength();
        }
        for (Talk t : track.getMorning_session().getTalkList()) {
            expectedTime += t.getLength();
        }
        assertEquals(expectedTime, actualTime, 0.1);
    }




}
