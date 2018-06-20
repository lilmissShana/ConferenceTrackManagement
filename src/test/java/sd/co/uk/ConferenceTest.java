package sd.co.uk;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class ConferenceTest {

    ArrayList<Talk> talkList;
    @Before
    public void setUp() throws Exception {


        talkList = new ArrayList<Talk>();

    }

    @Test
    public void testTestconf() {
        Talk t1 = new Talk("talk1", 60);
        Talk t2 = new Talk("talk2", 30);
        Talk t3 = new Talk("talk3", 40);
        Talk t4 = new Talk("talk4", 5);
        Talk t5 = new Talk("talk5",120);
        Talk t6 = new Talk("talk6", 115);
        Talk t7 = new Talk("talk6", 30);
        Talk t8 = new Talk("talk6", 5);
        Talk t9 = new Talk("talk6", 5);
        Talk t10 = new Talk("talk6", 60);
        Talk t11 = new Talk("talk6", 60);
        Talk t12 = new Talk("talk6", 30);
        Talk t13 = new Talk("talk6", 40);
        Talk t14 = new Talk("talk6", 5);
        Talk t15 = new Talk("talk6", 120);
        Talk t16 = new Talk("talk6", 115);
        Talk t17 = new Talk("talk6", 30);
        Talk t18= new Talk("talk6", 60);
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
        Conference conf = new Conference();
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
        Talk t1 = new Talk("talk1", 60);
        Talk t2 = new Talk("talk2", 45);
        Talk t3 = new Talk("talk3", 30);
        Talk t4 = new Talk("talk4", 45);
        Talk t5 = new Talk("talk5", 45);
        Talk t6 = new Talk("talk6", 5);
        Talk t7 = new Talk("talk7", 60);
        Talk t8 = new Talk("talk8", 45);
        Talk t9 = new Talk("talk9", 30);
        Talk t10 = new Talk("talk10", 30);
        Talk t11 = new Talk("talk11", 45);
        Talk t12 = new Talk("talk12", 60);
        Talk t13 = new Talk("talk13", 60);
        Talk t14 = new Talk("talk14", 45);
        Talk t15 = new Talk("talk15", 30);
        Talk t16 = new Talk("talk16", 30);
        Talk t17 = new Talk("talk17", 60);
        Talk t18 = new Talk("talk18", 30);
        Talk t19 = new Talk("talk19", 30);
        // sessions_list = new ArrayList<Integer>(Arrays.asList(60, 45, 30, 45, 45, 5, 60, 45, 30,
        // 30,
        // 45, 60, 60, 45, 30, 30, 60, 30, 30));

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
        Conference conf = new Conference();
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
            assertEquals(track.getMorning_session().getSessionLength(), 180);
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
        Talk talk1 = new Talk("talk1", 60);
        Talk talk2 = new Talk("talk2", 25);

        ArrayList<Talk> talkList = new ArrayList<Talk>();
        talkList.add(talk1);
        talkList.add(talk2);
        Conference conf = new Conference();
        conf.scheduleTalks(talkList);
    }

    @Test
    public void givenOneAndAHalfDaysofTalksShouldReturnTwoTracks() {
        Talk t1 = new Talk("talk1", 60);
        Talk t2 = new Talk("talk2", 45);
        Talk t3 = new Talk("talk3", 30);
        Talk t4 = new Talk("talk4", 45);
        Talk t5 = new Talk("talk5", 45);
        Talk t6 = new Talk("talk6", 5);
        Talk t7 = new Talk("talk7", 60);
        Talk t8 = new Talk("talk8", 45);
        Talk t9 = new Talk("talk9", 30);
        Talk t10 = new Talk("talk10", 30);
        Talk t11 = new Talk("talk11", 45);
        Talk t12 = new Talk("talk12", 60);
        Talk t13 = new Talk("talk13", 60);
        Talk t14 = new Talk("talk14", 45);
        Talk t15 = new Talk("talk15", 30);
        Talk t16 = new Talk("talk16", 30);
        Talk t17 = new Talk("talk17", 60);
        Talk t18 = new Talk("talk18", 30);
        Talk t19 = new Talk("talk19", 30);

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
        Conference conf = new Conference();
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
            assertEquals(track.getMorning_session().getSessionLength(), 180);
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
