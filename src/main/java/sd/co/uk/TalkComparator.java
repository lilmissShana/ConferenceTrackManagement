package sd.co.uk;

import java.util.Comparator;

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

