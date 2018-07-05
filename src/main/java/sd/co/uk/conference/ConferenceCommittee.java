package sd.co.uk.conference;

import java.util.ArrayList;

import sd.co.uk.domain.Talk;
import sd.co.uk.domain.Talk.Duration;

public class ConferenceCommittee {


    public static ArrayList<Talk> acceptTalkSubmission(String talkSubmissionToProcess, ArrayList<Talk> currentlyPlannedTalks)
            throws Exception {
        Talk talk;

        if (talkSubmissionToProcess.contains("lightning")) {
            talk = new Talk(talkSubmissionToProcess, Duration.LIGHTING);
            currentlyPlannedTalks.add(talk);

        } else if (talkSubmissionToProcess.contains("min")) {

            String title = talkSubmissionToProcess.substring(0, talkSubmissionToProcess.length() - 5);
            title = title.trim();
            int time = Integer.parseInt(talkSubmissionToProcess.substring(title.length(), talkSubmissionToProcess.length() - 3).trim());
            talk = new Talk(title, convertTime(time));
            currentlyPlannedTalks.add(talk);

        } else {
            throw new Exception("Cant organise talk - " + talkSubmissionToProcess);
        }
        return currentlyPlannedTalks;
    }

    /**
     * Converts int to Duration
     * 
     * @return Duration
     */
    private static Duration convertTime(int time) {

        if (time == 30) {
            return Duration.THIRTY_MINS;
        } else if (time == 45) {
            return Duration.FORTY_FIVE_MINS;

        } else if (time == 60) {
            return Duration.SIXTY_MIN;

        } else {
            throw new IllegalArgumentException("Not a valid talk duration");
        }

    }

}
