package sd.co.uk.domain;

import org.junit.Before;

import sd.co.uk.util.TalkDuration;

public class TalkTest {

    Talk talk;
    @Before
    public void setUp() throws Exception {
        talk = new Talk("Title", TalkDuration.FORTY_FIVE_MINS);
    }

    // TODO: these kinds of invariant test are good (and nice title) but we should really set up the class hierarchy so that this can't happen (see comments on the talk class)
    @Test
    public void givenThatNoStartTimeIsSetReturnNull() {
        assertEquals(talk.getStartTime(), null);
    }

    // TODO: add more invariant tests - so that you can read this test class and get a good idea of what a Talk is and isn't

}
