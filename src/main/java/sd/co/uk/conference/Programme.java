package sd.co.uk.conference;

import java.util.ArrayList;

import sd.co.uk.domain.Track;

public class Programme {


    /**
     * Prints the schedule for each track
     * 
     * @param trackList
     */
    public static void print(ArrayList<Track> trackList) {

        if (null != trackList) {
            for (Track track : trackList) {
                System.out.println(track.toString());
            }
        }
    }

}
