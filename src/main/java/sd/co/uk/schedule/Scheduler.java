package sd.co.uk.schedule;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import sd.co.uk.domain.ScheduledTalk;
import sd.co.uk.domain.Session;
import sd.co.uk.domain.Talk;
import sd.co.uk.domain.Track;
import sd.co.uk.util.TalkComparator;

// TODO: rename this class "ConferenceAutoScheduler"
public class Scheduler {


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
    public ArrayList<Track> scheduleTalks(ArrayList<Talk> unscheduledTalkList) throws Exception {

        // sort the list
        Collections.sort(unscheduledTalkList, new TalkComparator());
        
        int totalTalksLength = 0;
        // calculate length of combined talks
        for (Talk talk : unscheduledTalkList) {
            totalTalksLength += talk.getDuration().getTalkDurationAsInt();
        }
        int total_number_of_tracks = getTracksNeeded(totalTalksLength);

        if (total_number_of_tracks == 0) {
            throw new Exception("Not enough talks for a Scheduler Track.");
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
                unscheduledTalkList =
                        BuildMorningSession(track.getMorning_session(), unscheduledTalkList);
            }

            // create afternoon sessions
            for (Track track : tracksList) {
                unscheduledTalkList =
                        BuildAfternoonSession(track.getAfternoon_session(), unscheduledTalkList);
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
     * @param unscheduledTalksList
     * @return ArrayList<Talk>
     */
    private ArrayList<Talk> BuildMorningSession(Session morningSession,
            ArrayList<Talk> unscheduledTalksList) {
        Iterator<Talk> iterator = unscheduledTalksList.iterator();
        while (iterator.hasNext()) {

            Talk talk = iterator.next();
            LocalTime startTime = morningSession.getSessionStartTime();

            int session_length =
                    (morningSession.getSessionDuration() + talk.getDuration().getTalkDurationAsInt());
            if (session_length <= MORNING_LIMIT) {

                // update the session with new track
                LocalTime talkStartTime =
                        startTime.plusMinutes(morningSession.getSessionDuration());
                ScheduledTalk scheduledTalk =
                        new ScheduledTalk(talk.getTitle(), talk.getDuration(), talkStartTime);
                morningSession.getScheduledTalkList().add(scheduledTalk);
                iterator.remove();
            }

        }
        // if morning session has gaps - try again to fill it
        double session_gap = MORNING_LIMIT - morningSession.getSessionDuration();
        if (session_gap > 0) {
            this.ReOrganiseMorningSession(morningSession, unscheduledTalksList);
        }
        return unscheduledTalksList;
    }

    /**
     * Re organise morning session to ensure it is a full session
     * 
     * @param morningSession
     * @param unscheduledTalksList
     * @return ArrayList<Talk>
     */
    private ArrayList<Talk> ReOrganiseMorningSession(Session morningSession,
            ArrayList<Talk> unscheduledTalksList) {


        double session_gap = MORNING_LIMIT - morningSession.getSessionDuration();
        ArrayList<ScheduledTalk> scheduledTalkList = morningSession.getScheduledTalkList();

        boolean gapToFill = true;

        while (gapToFill) {
            ScheduledTalk removedScheduledTalk;
            if (scheduledTalkList.size() != 0) {
                removedScheduledTalk = scheduledTalkList.remove(scheduledTalkList.size() - 1);
                session_gap += removedScheduledTalk.getDuration().getTalkDurationAsInt();

                Iterator<Talk> unscheduledTalkListIterator = unscheduledTalksList.iterator();
                while (unscheduledTalkListIterator.hasNext()) {

                    Talk unscheduledTalk = unscheduledTalkListIterator.next();
                    LocalTime startTime = morningSession.getSessionStartTime();

                    int perposedDuration = morningSession.getSessionDuration()
                            + unscheduledTalk.getDuration().getTalkDurationAsInt();
                    if (perposedDuration <= MORNING_LIMIT) {

                        // update the session with new talk
                        LocalTime talkStartTime =
                                startTime.plusMinutes(morningSession.getSessionDuration());

                        ScheduledTalk scheduledTalk = new ScheduledTalk(unscheduledTalk.getTitle(),
                                unscheduledTalk.getDuration(), talkStartTime);
                        morningSession.getScheduledTalkList().add(scheduledTalk);
                        session_gap -= unscheduledTalk.getDuration().getTalkDurationAsInt();
                        unscheduledTalkListIterator.remove();
                    }
                }
                Talk talk = new Talk(removedScheduledTalk.getTitle(),
                        removedScheduledTalk.getDuration());
                unscheduledTalksList.add(talk);
            }

            if (session_gap <= 0) {
                gapToFill = false;
            }
        }
        return unscheduledTalksList;

    }
    
    /**
     * Builds afternoon session with talks by iterating through a talk list
     * 
     * @param afternoonSession
     * @param unscheduledTalkList
     * @return
     */
    private ArrayList<Talk> BuildAfternoonSession(Session afternoonSession,
            ArrayList<Talk> unscheduledTalkList) {

        Iterator<Talk> unscheduledIterator = unscheduledTalkList.iterator();
        while (unscheduledIterator.hasNext()) {
            Talk talk = unscheduledIterator.next();

            LocalTime startTime = afternoonSession.getSessionStartTime();

            int temp_total = afternoonSession.getSessionDuration()
                    + talk.getDuration().getTalkDurationAsInt();
            if (temp_total < AFTERNOON_LIMIT) {
                // update the session with new talk
                LocalTime talkStartTime =
                        startTime.plusMinutes(afternoonSession.getSessionDuration());
                ScheduledTalk scheduledTalk =
                        new ScheduledTalk(talk.getTitle(), talk.getDuration(), talkStartTime);
                afternoonSession.getScheduledTalkList().add(scheduledTalk);
                unscheduledIterator.remove();
            }
        }
        return unscheduledTalkList;

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
