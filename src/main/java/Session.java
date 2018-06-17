package main.java;

import java.time.LocalTime;
import java.util.ArrayList;

public class Session {

    private LocalTime sessionStartTime;
    private LocalTime sessionEndTime;

    private ArrayList<Talk> talkList;

    /**
     * @param sessionStartTime
     */
    public Session(LocalTime sessionStartTime) {
        this.sessionStartTime = sessionStartTime;
        talkList = new ArrayList<Talk>();
    }


    /**
     * @return the sessionStartTime
     */
    public LocalTime getSessionStartTime() {
        return sessionStartTime;
    }

    /**
     * @return the sessionEndTime
     */
    public LocalTime getSessionEndTime() {

        // to do: run though
        sessionEndTime = sessionStartTime.plusMinutes(getSessionLength());
        return sessionEndTime;
    }

    /**
     * @return the talkList
     */
    public ArrayList<Talk> getTalkList() {
        return talkList;
    }

    /**
     * @return the total session length as a double
     */
    public int getSessionLength() {

        int session_length = 0;

        for (Talk talk : talkList) {
            session_length += talk.getLength();
        }
        return session_length;
    }



}
