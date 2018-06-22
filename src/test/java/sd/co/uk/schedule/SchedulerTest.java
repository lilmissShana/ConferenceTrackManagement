package sd.co.uk.schedule;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import sd.co.uk.domain.Talk;
import sd.co.uk.domain.Track;
import sd.co.uk.util.TalkDuration;

public class SchedulerTest {

    ArrayList<Talk> talkList;
    @Before
    public void setUp() throws Exception {


        talkList = new ArrayList<Talk>();

    }

    @Test
    public void testTestconf() {
        Talk t1 = new Talk("talk1", TalkDuration.SIXTY_MIN);
        Talk t2 = new Talk("talk2", TalkDuration.THIRTY_MINS);
        Talk t3 = new Talk("talk3", TalkDuration.SIXTY_MIN);
        Talk t4 = new Talk("talk4", TalkDuration.LIGHTING);
        Talk t5 = new Talk("talk5", TalkDuration.SIXTY_MIN);
        Talk t6 = new Talk("talk6", TalkDuration.SIXTY_MIN);
        Talk t7 = new Talk("talk6", TalkDuration.THIRTY_MINS);
        Talk t8 = new Talk("talk6", TalkDuration.LIGHTING);
        Talk t9 = new Talk("talk6", TalkDuration.LIGHTING);
        Talk t10 = new Talk("talk6", TalkDuration.SIXTY_MIN);
        Talk t11 = new Talk("talk6", TalkDuration.SIXTY_MIN);
        Talk t12 = new Talk("talk6", TalkDuration.THIRTY_MINS);
        Talk t13 = new Talk("talk6", TalkDuration.SIXTY_MIN);
        Talk t14 = new Talk("talk6", TalkDuration.LIGHTING);
        Talk t15 = new Talk("talk6", TalkDuration.SIXTY_MIN);
        Talk t16 = new Talk("talk6", TalkDuration.SIXTY_MIN);
        Talk t17 = new Talk("talk6", TalkDuration.THIRTY_MINS);
        Talk t18 = new Talk("talk6", TalkDuration.SIXTY_MIN);
        Talk t19 = new Talk("talk6", TalkDuration.SIXTY_MIN);
        Talk t20 = new Talk("talk6", TalkDuration.SIXTY_MIN);
        talkList.add(t1);
        talkList.add(t2);
        talkList.add(t3);
        talkList.add(t4);
        talkList.add(t5);
        talkList.add(t6);
        talkList.add(t7);
        talkList.add(t8);
        talkList.add(t9);
        talkList.add(t10);
        talkList.add(t11);
        talkList.add(t12);
        talkList.add(t13);
        talkList.add(t14);
        talkList.add(t15);
        talkList.add(t16);
        talkList.add(t17);
        talkList.add(t18);
        Scheduler conf = new Scheduler();
        ArrayList<Track> trackList = null;
        try {
            trackList = conf.scheduleTalks(talkList);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (Track track : trackList) {
            System.out.println(track.toString() + "-----");
        }

    }

    @Test
    public void testTestconfTwoTracks() {
        Talk t1 = new Talk("talk1", TalkDuration.SIXTY_MIN);
        Talk t2 = new Talk("talk2", TalkDuration.FORTY_FIVE_MINS);
        Talk t3 = new Talk("talk3", TalkDuration.THIRTY_MINS);
        Talk t4 = new Talk("talk4", TalkDuration.FORTY_FIVE_MINS);
        Talk t5 = new Talk("talk5", TalkDuration.FORTY_FIVE_MINS);
        Talk t6 = new Talk("talk6", TalkDuration.LIGHTING);
        Talk t7 = new Talk("talk7", TalkDuration.SIXTY_MIN);
        Talk t8 = new Talk("talk8", TalkDuration.FORTY_FIVE_MINS);
        Talk t9 = new Talk("talk9", TalkDuration.THIRTY_MINS);
        Talk t10 = new Talk("talk10", TalkDuration.THIRTY_MINS);
        Talk t11 = new Talk("talk11", TalkDuration.FORTY_FIVE_MINS);
        Talk t12 = new Talk("talk12", TalkDuration.SIXTY_MIN);
        Talk t13 = new Talk("talk13", TalkDuration.SIXTY_MIN);
        Talk t14 = new Talk("talk14", TalkDuration.FORTY_FIVE_MINS);
        Talk t15 = new Talk("talk15", TalkDuration.THIRTY_MINS);
        Talk t16 = new Talk("talk16", TalkDuration.THIRTY_MINS);
        Talk t17 = new Talk("talk17", TalkDuration.SIXTY_MIN);
        Talk t18 = new Talk("talk18", TalkDuration.THIRTY_MINS);
        Talk t19 = new Talk("talk19", TalkDuration.THIRTY_MINS);

        talkList.add(t1);
        talkList.add(t2);
        talkList.add(t3);
        talkList.add(t4);
        talkList.add(t5);
        talkList.add(t6);
        talkList.add(t7);
        talkList.add(t8);
        talkList.add(t9);
        talkList.add(t10);
        talkList.add(t11);
        talkList.add(t12);
        talkList.add(t13);
        talkList.add(t14);
        talkList.add(t15);
        talkList.add(t16);
        talkList.add(t17);
        talkList.add(t18);
        talkList.add(t19);
        Scheduler conf = new Scheduler();
        ArrayList<Track> trackList = null;
        try {
            trackList = conf.scheduleTalks(talkList);
            assertEquals(trackList.size(), 2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Track track : trackList) {
            assertEquals(LocalTime.parse("09:00"),
                    track.getMorning_session().getSessionStartTime());
            assertEquals(track.getMorning_session().getSessionDuration(), 180);
            assertEquals(LocalTime.parse("13:00"),
                    track.getAfternoon_session().getSessionStartTime());
            LocalTime endTime = track.getAfternoon_session().getSessionEndTime();

            if (!endTime.isAfter(LocalTime.parse("15:59"))
                    && !endTime.isBefore(LocalTime.parse("17:00"))) {

                Assert.fail();

            }
                
        }

    }

    @Test (expected = Exception.class)
    public void giveThatOnlyTwoTalksExistShouldReturnError() throws Exception {
        Talk talk1 = new Talk("talk1", TalkDuration.FORTY_FIVE_MINS);
        Talk talk2 = new Talk("talk2", TalkDuration.FORTY_FIVE_MINS);

        ArrayList<Talk> talkList = new ArrayList<Talk>();
        talkList.add(talk1);
        talkList.add(talk2);
        Scheduler conf = new Scheduler();
        conf.scheduleTalks(talkList);
    }

    @Test
    public void givenOneAndAHalfDaysofTalksShouldReturnTwoTracks() {
        Talk t1 = new Talk("talk1", TalkDuration.SIXTY_MIN);
        Talk t2 = new Talk("talk2", TalkDuration.FORTY_FIVE_MINS);
        Talk t3 = new Talk("talk3", TalkDuration.THIRTY_MINS);
        Talk t4 = new Talk("talk4", TalkDuration.FORTY_FIVE_MINS);
        Talk t5 = new Talk("talk5", TalkDuration.FORTY_FIVE_MINS);
        Talk t6 = new Talk("talk6", TalkDuration.LIGHTING);
        Talk t7 = new Talk("talk7", TalkDuration.SIXTY_MIN);
        Talk t8 = new Talk("talk8", TalkDuration.FORTY_FIVE_MINS);
        Talk t9 = new Talk("talk9", TalkDuration.THIRTY_MINS);
        Talk t10 = new Talk("talk10", TalkDuration.THIRTY_MINS);
        Talk t11 = new Talk("talk11", TalkDuration.FORTY_FIVE_MINS);
        Talk t12 = new Talk("talk12", TalkDuration.SIXTY_MIN);
        Talk t13 = new Talk("talk13", TalkDuration.SIXTY_MIN);
        Talk t14 = new Talk("talk14", TalkDuration.FORTY_FIVE_MINS);
        Talk t15 = new Talk("talk15", TalkDuration.THIRTY_MINS);
        Talk t16 = new Talk("talk16", TalkDuration.THIRTY_MINS);
        Talk t17 = new Talk("talk17", TalkDuration.SIXTY_MIN);
        Talk t18 = new Talk("talk18", TalkDuration.THIRTY_MINS);
        Talk t19 = new Talk("talk19", TalkDuration.THIRTY_MINS);

        talkList.add(t1);
        talkList.add(t2);
        talkList.add(t3);
        talkList.add(t4);
        talkList.add(t5);
        talkList.add(t6);
        talkList.add(t7);
        talkList.add(t8);
        talkList.add(t9);
        talkList.add(t10);
        talkList.add(t11);
        talkList.add(t12);
        talkList.add(t13);
        talkList.add(t14);
        talkList.add(t15);
        talkList.add(t16);
        talkList.add(t17);
        talkList.add(t18);
        talkList.add(t19);
        Scheduler conf = new Scheduler();
        ArrayList<Track> trackList = null;
        try {
            trackList = conf.scheduleTalks(talkList);

            assertEquals(trackList.size(), 2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Track track : trackList) {
            assertEquals(LocalTime.parse("09:00"),
                    track.getMorning_session().getSessionStartTime());
            assertEquals(track.getMorning_session().getSessionDuration(), 180);
            assertEquals(LocalTime.parse("13:00"),
                    track.getAfternoon_session().getSessionStartTime());
        }

    }

    @Test
    public void testBuildMorningSession() {

    }

    @Test
    public void testBuildAfternoonSession() {

    }


}
