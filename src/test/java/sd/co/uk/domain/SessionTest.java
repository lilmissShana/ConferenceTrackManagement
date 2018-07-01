package sd.co.uk.domain;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import sd.co.uk.util.TalkDuration;

public class SessionTest {

    Session session;
    @Before
    public void setUp() throws Exception {

        ScheduledTalk t1 = new ScheduledTalk("talk1", TalkDuration.SIXTY_MIN, LocalTime.NOON);
        ScheduledTalk t2 = new ScheduledTalk("talk2", TalkDuration.LIGHTING, LocalTime.NOON);

        LocalTime m_start_time = LocalTime.parse("09:00");
        session = new Session(m_start_time);
        session.getScheduledTalkList().add(t1);
        session.getScheduledTalkList().add(t2);
    }

    // TODO: add lots more invariant tests - but make sure not to test Talks as they are tested in the TalkTest class.  Try and think about what a session can and can't be, but stick to what the code needs to do - don't add things you don't need

    @Test
    public void testGetSessionLength() {
        double actualTime = session.getSessionDuration();
        double expectedTime = 0;

        for (ScheduledTalk t : session.getScheduledTalkList()) {
            expectedTime += t.getDuration().getTalkDurationAsInt();
        }
        assertEquals(expectedTime, actualTime, 0.1);
    }

}
