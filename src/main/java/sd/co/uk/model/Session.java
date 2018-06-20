package sd.co.uk.model;

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


    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sessionEndTime == null) ? 0 : sessionEndTime.hashCode());
        result = prime * result + ((sessionStartTime == null) ? 0 : sessionStartTime.hashCode());
        result = prime * result + ((talkList == null) ? 0 : talkList.hashCode());
        return result;
    }


    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Session other = (Session) obj;
        if (sessionEndTime == null) {
            if (other.sessionEndTime != null)
                return false;
        } else if (!sessionEndTime.equals(other.sessionEndTime))
            return false;
        if (sessionStartTime == null) {
            if (other.sessionStartTime != null)
                return false;
        } else if (!sessionStartTime.equals(other.sessionStartTime))
            return false;
        if (talkList == null) {
            if (other.talkList != null)
                return false;
        } else if (!talkList.equals(other.talkList))
            return false;
        return true;
    }


    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Session [sessionStartTime=" + sessionStartTime + ", sessionEndTime="
                + sessionEndTime + ", talkList=" + talkList + "]";
    }



}
