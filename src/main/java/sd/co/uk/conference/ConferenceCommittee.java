package sd.co.uk.conference;

import java.util.ArrayList;

import sd.co.uk.domain.Talk;
import sd.co.uk.util.TalkDuration;

public class ConferenceCommittee {

    public static ArrayList<Talk> organiseTalk(String line, ArrayList<Talk> talkList)
            throws Exception {
        Talk talk;

        if (line.contains("lightning")) {
            talk = new Talk(line, TalkDuration.LIGHTING);
            talkList.add(talk);

        } else if (line.contains("min")) {

            String title = line.substring(0, line.length() - 5);
            title = title.trim();
            int time = Integer.parseInt(line.substring(title.length(), line.length() - 3).trim());
            talk = new Talk(title, convertTime(time));
            talkList.add(talk);

        } else {
            throw new Exception("Cant organise talk - " + line);
        }
        return talkList;
    }

    /**
     * Converts int to TalkDuration
     * 
     * @return TalkDuration
     */
    private static TalkDuration convertTime(int time) {

        if (time == 30) {
            return TalkDuration.THIRTY_MINS;
        } else if (time == 45) {
            return TalkDuration.FORTY_FIVE_MINS;

        } else if (time == 60) {
            return TalkDuration.SIXTY_MIN;

        } else {
            throw new IllegalArgumentException("Not a valid talk duration");
        }

    }

}
