package sd.co.uk.domain;

import org.junit.Before;

import sd.co.uk.util.TalkDuration;

public class TalkTest {

    Talk talk;
    @Before
    public void setUp() throws Exception {
        talk = new Talk("Title", TalkDuration.FORTY_FIVE_MINS);
    }




}
