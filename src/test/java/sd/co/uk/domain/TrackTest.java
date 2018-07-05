package sd.co.uk.domain;

import static org.junit.Assert.assertTrue;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import resources.TestUtils;



public class TrackTest {


    @Before
    public void setUp() {


    }


    // TODO: you can make this "assertTrue", and some of the ones below also
    @Test
    public void givenValidTrackWhenGetMorningSessionShouldReturnCorrectSessionDetails() {
        Track track = TestUtils.createExampleTrack();
        assertTrue(track.getMorningSession().getScheduledTalkList().size() == 2);
        assertTrue(track.getMorningSession().getSessionDuration() == 120);
        assertTrue(track.getMorningSession().getSessionEndTime()
                .equals(TestUtils.morningStartTime.plusMinutes(120)));
        assertTrue(
                track.getMorningSession().getSessionStartTime().equals(TestUtils.morningStartTime));
    }
    @Test
    public void givenValidTrackWhenGetAfternoonSessionShouldReturnCorrectSessionDetails() {
        Track track = TestUtils.createExampleTrack();
        assertTrue(track.getAfternoonSession().getScheduledTalkList().size() == 5);
        assertTrue(track.getAfternoonSession().getSessionDuration() == 190);
        assertTrue(track.getAfternoonSession().getSessionEndTime()
                .equals(TestUtils.afternoonStartTime.plusMinutes(190)));
        assertTrue(
                track.getMorningSession().getSessionStartTime().equals(TestUtils.morningStartTime));
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenEmptyStringAsNameWhenTrackConstructedErrorIsThrown() {
        Track track = new Track("");
    }

    @Test(expected = NullPointerException.class)
    public void givenNullStringAsNameWhenTrackConstructedErrorIsThrown() {
        Track track = new Track(null);
    }

    @Test
    public void givenValidTrackWithTalksWhenGetLunchStartTimeCalledShouldReturnCorrectTime() {
        Track track = TestUtils.createExampleTrack();
        LocalTime actualTime = track.getLunchStartTime();
        LocalTime expectedTime = LocalTime.parse("12:00");
        assertTrue(actualTime.equals(expectedTime));
    }
    @Test
    public void givenValidTrackWithTalksWhenGetStartTimeCalledShouldReturnCorrectTime() {
        Track track = TestUtils.createExampleTrack();
        LocalTime actualTime = track.getStartTime();
        LocalTime expectedTime = TestUtils.morningStartTime;
        assertTrue(actualTime.equals(expectedTime));
    }

    @Test
    public void givenValidTrackWithTalksWhenGetTotalTalksDurationCalledShouldReturnCorrectDuration() {
        Track track = TestUtils.createExampleTrack();
        double actualDuration = track.getTotalTalksDuration();
        double expectedDuration = 310;
        assertTrue(actualDuration == expectedDuration);
    }

    @Test
    public void givenTrackWithTalksWhenGetNetworkEventStartTimeCalledShouldReturnCurrectTime() {
        Track track = TestUtils.createExampleTrack();
        LocalTime actualTime = track.getNetworkEventStartTime();
        LocalTime defaultTime = LocalTime.parse("16:10");
        assertTrue(actualTime.equals(defaultTime));

    }



}
