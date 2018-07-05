package sd.co.uk.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import sd.co.uk.domain.Talk.Duration;

public class SessionTest {

    Session session;
    LocalTime sessionStartTime;
    @Before
    public void setUp() {

        ScheduledTalk t1 = new ScheduledTalk("talk1", Duration.SIXTY_MIN, LocalTime.NOON);
        ScheduledTalk t2 = new ScheduledTalk("talk2", Duration.LIGHTING, LocalTime.NOON);

        sessionStartTime = LocalTime.parse("09:00");
        session = new Session(sessionStartTime);
        session.getScheduledTalkList().add(t1);
        session.getScheduledTalkList().add(t2);
    }

    @Test
    public void givenValidSessionWhenGetSessionDurationCalledShouldReturnCorrectDuration() {
        double actualDuration = session.getSessionDuration();
        double sessionDuration = 0;

        for (ScheduledTalk talk : session.getScheduledTalkList()) {
            sessionDuration += talk.getDurationAsInt();
        }
        assertEquals(sessionDuration, actualDuration, 0.1);
    }

    @Test
    public void givenValidSessionWhenGetSessionStartTimeCalledShouldReturnCorrectStartTime() {
        LocalTime actualStartTime = session.getSessionStartTime();

        assertTrue(actualStartTime.equals(sessionStartTime));
    }

    @Test
    public void givenValidSessionWhenGetSessionEndTimeCalledShouldReturnCorrectEndTime() {
        LocalTime actualEndTime = session.getSessionEndTime();

        assertTrue(actualEndTime.equals(sessionStartTime.plusMinutes(
                Duration.SIXTY_MIN.getDurationAsInt() + Duration.LIGHTING.getDurationAsInt())));
    }

    @Test
    public void givenSessionWithNoTalksWhenGetSessionDurationCalledShouldReturnZero() {
        Session session = new Session(sessionStartTime);
        double actualDuration = session.getSessionDuration();

        assertEquals(0, actualDuration, 0.1);
    }

}
