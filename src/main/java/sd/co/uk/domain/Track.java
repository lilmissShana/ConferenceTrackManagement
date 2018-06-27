package sd.co.uk.domain;

import java.time.LocalTime;

public final class Track {

    private final String name;

    private final Session morningSession;
    private final Session afternoonSession;

    private final static LocalTime morningStartTime = LocalTime.parse("09:00");
    private final static LocalTime lunchStartTime = LocalTime.parse("12:00");
    private final static LocalTime afternoonStartTime = LocalTime.parse("13:00");
    private final static LocalTime networkEventStartTime = LocalTime.parse("16:00");


    /**
     * @param name
     * @param morningSession
     * @param afternoonSession
     */
    public Track(String name, Session morningSession, Session afternoonSession) {
        if (name.isEmpty() || name == null) {
            throw new IllegalArgumentException("Name can't be null or empty");

        } else {
            this.name = name;
        }
        if (morningSession == null) {
            throw new IllegalArgumentException("morningSession can't be null");
        } else {
            this.morningSession = morningSession;
        }
        if (afternoonSession == null) {
            throw new IllegalArgumentException("afternoonSession can't be null");
        } else {
            this.afternoonSession = afternoonSession;
        }

    }

    /**
     * @param name
     */
    public Track(String name) {

        this(name, new Session(morningStartTime), new Session(afternoonStartTime));
    }

    /**
     * @return the morning_session
     */
    // TODO: method naming!
    public Session getMorning_session() {
        Session session = morningSession;
        return session;
    }


    /**
     * @return the afternoon_session
     */
    // TODO: method naming!
    public Session getAfternoon_session() {
        Session session = afternoonSession;
        return session;
    }



    /**
     * @return the lunchStartTime
     */
    public LocalTime getLunchStartTime() {
        return lunchStartTime;
    }


    /**
     * @return the start_time
     */
    // TODO: method naming!
    public LocalTime getStart_time() {
        return morningSession.getSessionStartTime();
    }


    /**
     * @return the total track length without the network event
     */
    public double getTotalTalksDuration() {

        double morning_length = morningSession.getSessionDuration();
        double afternoon_length = afternoonSession.getSessionDuration();
        return morning_length + afternoon_length;

    }

    /**
     * @return the Network event start time
     */
    public LocalTime getNetworkEventStartTime() {

        double endtime = afternoonSession.getSessionDuration();
        if (endtime <= 180) {
            return networkEventStartTime;
        } else {
            return networkEventStartTime.plusMinutes(60);
        }

    }

    @Override
    public String toString() {
        
        String output = name + "\n";
        for (ScheduledTalk scheduledTalk : morningSession.getScheduledTalkList()) {
            output += scheduledTalk.toString() + "\n";
        }
        output += lunchStartTime + " Lunch Time \n";
        for (ScheduledTalk scheduledTalk : afternoonSession.getScheduledTalkList()) {
            output += scheduledTalk.toString() + "\n";
        }
        output += getNetworkEventStartTime() + " Network Event \n";;
        return output;
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
        result = prime * result + ((afternoonSession == null) ? 0 : afternoonSession.hashCode());
        result = prime * result
                + ((afternoonStartTime == null) ? 0 : afternoonStartTime.hashCode());
        result = prime * result + ((lunchStartTime == null) ? 0 : lunchStartTime.hashCode());
        result = prime * result + ((morningSession == null) ? 0 : morningSession.hashCode());
        result = prime * result + ((morningStartTime == null) ? 0 : morningStartTime.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result
                + ((networkEventStartTime == null) ? 0 : networkEventStartTime.hashCode());
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
        Track other = (Track) obj;
        if (afternoonSession == null) {
            if (other.afternoonSession != null)
                return false;
        } else if (!afternoonSession.equals(other.afternoonSession))
            return false;
        if (afternoonStartTime == null) {
            if (other.afternoonStartTime != null)
                return false;
        } else if (!afternoonStartTime.equals(other.afternoonStartTime))
            return false;
        if (lunchStartTime == null) {
            if (other.lunchStartTime != null)
                return false;
        } else if (!lunchStartTime.equals(other.lunchStartTime))
            return false;
        if (morningSession == null) {
            if (other.morningSession != null)
                return false;
        } else if (!morningSession.equals(other.morningSession))
            return false;
        if (morningStartTime == null) {
            if (other.morningStartTime != null)
                return false;
        } else if (!morningStartTime.equals(other.morningStartTime))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (networkEventStartTime == null) {
            if (other.networkEventStartTime != null)
                return false;
        } else if (!networkEventStartTime.equals(other.networkEventStartTime))
            return false;
        return true;
    }



}
