package sd.co.uk.view;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import sd.co.uk.model.Session;
import sd.co.uk.model.Talk;
import sd.co.uk.model.Track;
import sd.co.uk.util.TalkComparator;

public class Conference {


//    Presenters will be very punctual; there needs to be no gap between sessions.
    private final int MORNING_LIMIT = 180; // 420 in all
    private final int AFTERNOON_LIMIT = 240; // 5hours
    private final int TRACK_MIN = 360;
    private final int TRACK_MAX = 420;


    /**
     * Arranges talks into 1 or more tracks. Throws exception if not enough talk for 1 track.
     * 
     * @param ArrayList<Talk>
     * @return ArrayList<Track>
     * @throws Exception
     */
    public ArrayList<Track> scheduleTalks(ArrayList<Talk> talkList) throws Exception {

        // sort the list
        Collections.sort(talkList, new TalkComparator());
        
        int totalTalksLength = 0;
        // calculate length of combined talks
        for (Talk talk : talkList) {
            totalTalksLength += talk.getLength();
        }
        int total_number_of_tracks = getTracksNeeded(totalTalksLength);

        if (total_number_of_tracks == 0) {
            throw new Exception("Not enough talks for a Conference Track.");
        }
        else {

            ArrayList<Track> tracksList = new ArrayList<Track>(total_number_of_tracks);

            if (total_number_of_tracks == 1) {
                Track track = new Track("Track 0");
                tracksList.add(track);
            } else {
                for (int i = 0; i < total_number_of_tracks; i++) {
                    Track track = new Track("Track " + i);
                    tracksList.add(track);
                }
            }
            // create all morning sessions
            for (Track track : tracksList) {
                talkList = BuildMorningSession(track.getMorning_session(), talkList);
            }

            // create afternoon sessions
            for (Track track : tracksList) {
                talkList = BuildAfternoonSession(track.getAfternoon_session(), talkList);
            }

            return tracksList;
        }
    }


    /**
     * 
     * Builds morning session with talks by iterating through a talk list and insuring session
     * beginnings at session start time and finish at session end time.
     * 
     * @param morningSession
     * @param talksList
     * @return ArrayList<Talk>
     */
    private ArrayList<Talk> BuildMorningSession(Session morningSession, ArrayList<Talk> talksList) {

        Iterator<Talk> iterator = talksList.iterator();
        while (iterator.hasNext()) {

            Talk talk = iterator.next();
            LocalTime startTime = morningSession.getSessionStartTime();

            int session_length = (morningSession.getSessionLength() + talk.getLength());
            if (session_length <= MORNING_LIMIT) {

                // update the session with new track
                LocalTime talkTime =
                        startTime.plusMinutes(morningSession.getSessionLength());
                talk.setStartTime(talkTime);
                morningSession.getTalkList().add(talk);
                iterator.remove();
            }

        }
        // if morning session has gaps - try again to fill it
        double session_gap = MORNING_LIMIT - morningSession.getSessionLength();
        ArrayList<Talk> sessionList = morningSession.getTalkList();

        if (session_gap != 0) {
            boolean gapToFill = true;

            while (gapToFill) {
                Talk talk;
                if (sessionList.size() != 0) {
                    talk = sessionList.remove(sessionList.size() - 1);
                    session_gap += talk.getLength();
                    
                    Iterator<Talk> iterator2 = talksList.iterator();
                    while (iterator2.hasNext()) {

                        Talk talk2 = iterator2.next();
                        LocalTime startTime = morningSession.getSessionStartTime();

                        int temp_total =
                                morningSession.getSessionLength() + talk2.getLength();
                        if (temp_total <= MORNING_LIMIT) {

                            // update the session with new talk
                            LocalTime talkTime =
                                    startTime.plusMinutes(morningSession.getSessionLength());
                            talk2.setStartTime(talkTime);
                            morningSession.getTalkList().add(talk2);
                            session_gap -= talk2.getLength();
                            iterator2.remove();
                        }
                    }
                    talksList.add(talk);
                }

                if (session_gap <= 0) {
                    gapToFill = false;
                }
            }
        }

        return talksList;

    }
    
    /**
     * Builds afternoon session with talks by iterating through a talk list
     * 
     * @param afternoonSession
     * @param talkList
     * @return
     */
    private ArrayList<Talk> BuildAfternoonSession(Session afternoonSession,
            ArrayList<Talk> talkList) {

        Iterator<Talk> iterator = talkList.iterator();
        while (iterator.hasNext()) {
            Talk talk = iterator.next();

            LocalTime startTime = afternoonSession.getSessionStartTime();

            int temp_total = afternoonSession.getSessionLength()
                    + talk.getLength();
            if (temp_total < AFTERNOON_LIMIT) {
                // update the session with new talk
                LocalTime talkTime =
                        startTime.plusMinutes(afternoonSession.getSessionLength());
                talk.setStartTime(talkTime);
                afternoonSession.getTalkList().add(talk);
                iterator.remove();
            }

        }
        return talkList;

    }

    /**
     * Returns number of tracks need given a combined talk time
     * 
     * @param total_track_time
     * @return int
     */
    private int getTracksNeeded(int total_track_time) {
        return total_track_time / TRACK_MIN;
    }

}
