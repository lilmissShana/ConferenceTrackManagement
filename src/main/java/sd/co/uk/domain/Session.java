package sd.co.uk.domain;

import java.time.LocalTime;
import java.util.ArrayList;

public class Session {

    private LocalTime sessionStartTime;
    private LocalTime sessionEndTime;

    private ArrayList<ScheduledTalk> scheduledTalkList;

    /**
     * @param sessionStartTime
     */
    public Session(LocalTime sessionStartTime) {
        this.sessionStartTime = sessionStartTime;
        scheduledTalkList = new ArrayList<ScheduledTalk>();
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
        sessionEndTime = sessionStartTime.plusMinutes(getSessionDuration());
        return sessionEndTime;
    }

    /**
     * @return the scheduledTalkList
     */
    public ArrayList<ScheduledTalk> getScheduledTalkList() {
        return scheduledTalkList;
    }

    /**
     * @return the current session duration as a double
     */
    public int getSessionDuration() {

        int session_length = 0;

        for (ScheduledTalk scheduledTalk : scheduledTalkList) {
            session_length += scheduledTalk.getDurationAsInt();
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
        result = prime * result + ((scheduledTalkList == null) ? 0 : scheduledTalkList.hashCode());
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
        if (scheduledTalkList == null) {
            if (other.scheduledTalkList != null)
                return false;
        } else if (!scheduledTalkList.equals(other.scheduledTalkList))
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
                + sessionEndTime + ", scheduledTalkList=" + scheduledTalkList + "]";
    }



}
