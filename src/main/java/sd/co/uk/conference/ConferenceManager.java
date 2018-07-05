package sd.co.uk.conference;

import java.io.File;
import java.util.ArrayList;

import sd.co.uk.domain.Talk;
import sd.co.uk.domain.Track;
import sd.co.uk.schedule.ConferenceAutoScheduler;

// TODO: the contents of this class should be very small - pull all the logic out into classes with meaningful names
public class ConferenceManager {

    static ArrayList<Talk> currentlyPlannedTalks = new ArrayList<Talk>();

    /**
     * This is a main driver function. Receives the talks, schedules them into tracks, then print
     * overall conference programme.
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // if a file is given at run time read it
        if (args.length != 0) {
            String file_name = args[0].trim();
            File file = new File(file_name);
            currentlyPlannedTalks = CallForPapers.submitTalks(file);
        } else {
            // else read from terminal
            currentlyPlannedTalks = CallForPapers.submitTalks();
        }

        ConferenceAutoScheduler conferenceAutoScheduler = new ConferenceAutoScheduler();

        ArrayList<Track> plannedTracks = new ArrayList<Track>();
        try {
            plannedTracks = conferenceAutoScheduler.scheduleTalks(currentlyPlannedTalks);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Programme.print(plannedTracks);

    }

}
