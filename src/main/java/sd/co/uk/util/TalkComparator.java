package sd.co.uk.util;

import java.util.Comparator;

import sd.co.uk.model.Talk;

public class TalkComparator implements Comparator<Talk> {

    // compare the talks and returns the gratest
    @Override
    public int compare(Talk talk1, Talk talk2) {
        if (talk1.getLength() < talk2.getLength()) {
            return 1;
        } else {
            return -1;
        }
    }

}

