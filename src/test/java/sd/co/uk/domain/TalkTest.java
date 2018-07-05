package sd.co.uk.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import sd.co.uk.domain.Talk.Duration;



public class TalkTest {

    Talk talk;
    String title;
    @Before
    public void setUp() throws Exception {
        title = "Title";
        talk = new Talk(title, Duration.FORTY_FIVE_MINS);
    }

    @Test
    public void givenThatTalkExistGetDuration() {
        assertTrue(talk.getDuration().equals(Duration.FORTY_FIVE_MINS));

    }

    @Test
    public void givenThatTalkExistGetDurationAsInt() {
        assertTrue(talk.getDurationAsInt() == 45);

    }

    @Test
    public void givenThatTalkExistGetTitle() {
        assertTrue(talk.getTitle().equals(title));

    }

    @Test(expected = IllegalArgumentException.class)
    public void givenEmptyStringAsTitleWhenTalkConstructedErrorIsThrown() {
        Talk talk = new Talk("", Duration.FIFTEEN_MINS);

    }

}
