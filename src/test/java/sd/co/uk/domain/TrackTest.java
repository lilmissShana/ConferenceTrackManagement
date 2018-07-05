package sd.co.uk.domain;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import sd.co.uk.domain.Talk.Duration;



public class TrackTest {

    Track track;
    Session morningSession;
    Session afternoonSession;

    @Before
    public void setUp() throws Exception {
        ScheduledTalk t1 = new ScheduledTalk("talk1", Duration.SIXTY_MIN, LocalTime.NOON);
        ScheduledTalk t2 = new ScheduledTalk("talk2", Duration.SIXTY_MIN, LocalTime.NOON);
        ScheduledTalk t3 = new ScheduledTalk("talk3", Duration.SIXTY_MIN, LocalTime.NOON);
        ScheduledTalk t4 = new ScheduledTalk("talk4", Duration.SIXTY_MIN, LocalTime.NOON);
        ScheduledTalk t5 = new ScheduledTalk("talk5", Duration.LIGHTING, LocalTime.NOON);
        ScheduledTalk t6 = new ScheduledTalk("talk6", Duration.LIGHTING, LocalTime.NOON);
        LocalTime m_start_time = LocalTime.parse("09:00");
        LocalTime a_start_time = LocalTime.parse("13:00");

        

        morningSession = new Session(m_start_time);
        morningSession.getScheduledTalkList().add(t1);
        morningSession.getScheduledTalkList().add(t2);

        afternoonSession = new Session(a_start_time);
        afternoonSession.getScheduledTalkList().add(t3);
        afternoonSession.getScheduledTalkList().add(t4);
        afternoonSession.getScheduledTalkList().add(t5);
        afternoonSession.getScheduledTalkList().add(t6);

        track = new Track("Track 1", morningSession, afternoonSession);

    }


    // TODO: you can make this "assertTrue", and some of the ones below also
    @Test
    public void testGetMorning_session() {
        assertTrue(true, track.getMorningSession().equals(morningSession));
    }

    @Test
    public void testGetAfternoon_session() {
        assertEquals(true, track.getAfternoonSession().equals(afternoonSession));
    }

    @Test
    public void testGetTotalTalkTime() {
        double actualTime = track.getTotalTalksDuration();
        double expectedTime = 0;

        for (ScheduledTalk t : track.getAfternoonSession().getScheduledTalkList()) {
            expectedTime += t.getDurationAsInt();
        }
        for (ScheduledTalk t : track.getMorningSession().getScheduledTalkList()) {
            expectedTime += t.getDurationAsInt();
        }
        assertEquals(expectedTime, actualTime, 0.1);
    }




}
