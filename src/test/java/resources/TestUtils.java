package resources;

import java.time.LocalTime;

import sd.co.uk.domain.ScheduledTalk;
import sd.co.uk.domain.Talk.Duration;
import sd.co.uk.domain.Track;

public class TestUtils {

    public static LocalTime morningStartTime = LocalTime.parse("09:00");
    public static LocalTime afternoonStartTime = LocalTime.parse("13:00");


    public static Track createExampleTrack() {
        ScheduledTalk t1 = new ScheduledTalk("talk1", Duration.SIXTY_MIN, LocalTime.parse("09:00"));
        ScheduledTalk t2 = new ScheduledTalk("talk2", Duration.SIXTY_MIN, LocalTime.parse("10:00"));
        ScheduledTalk t3 = new ScheduledTalk("talk3", Duration.SIXTY_MIN, LocalTime.parse("11:00"));
        // lunch
        ScheduledTalk t4 = new ScheduledTalk("talk4", Duration.SIXTY_MIN, LocalTime.parse("13:00"));
        ScheduledTalk t5 = new ScheduledTalk("talk5", Duration.LIGHTING, LocalTime.parse("14:00"));
        ScheduledTalk t6 = new ScheduledTalk("talk6", Duration.LIGHTING, LocalTime.parse("14:05"));
        ScheduledTalk t7 = new ScheduledTalk("talk6", Duration.SIXTY_MIN, LocalTime.parse("14:10"));

        Track track = new Track("Track 1");

        track.getMorningSession().getScheduledTalkList().add(t1);
        track.getMorningSession().getScheduledTalkList().add(t2);

        track.getAfternoonSession().getScheduledTalkList().add(t3);
        track.getAfternoonSession().getScheduledTalkList().add(t4);
        track.getAfternoonSession().getScheduledTalkList().add(t5);
        track.getAfternoonSession().getScheduledTalkList().add(t6);
        track.getAfternoonSession().getScheduledTalkList().add(t7);

        return track;

    }


}
