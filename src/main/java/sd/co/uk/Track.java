package sd.co.uk; // todo: move to a ".domain" package

import java.time.LocalTime;

public class Track {

    private Session morningSession;
    private Session afternoonSession;
    private LocalTime lunchStartTime;
    private LocalTime afternoonStartTime;
    private LocalTime morningStartTime; // TODO: reorder this to put it before lunchStartTime (it reads more nicely)
    private String name; // TODO: put this at the top
    private LocalTime networkEventStartTime = LocalTime.parse("16:00");


    /**
     * @param morning_session
     * @param afternoon_session
     * @param lunchStartTime
     * @param nextwork_start_time
     * @param start_time
     */
    // TODO: put some checks in this contrucor to ensure relevant invariants
    // TODO: check name, morningSession, afternoonSession and lunmch_start_time aren't null
    public Track(String name, Session morningSession, Session afternoonSession,
            LocalTime lunch_start_time) {
        this.name = name;
        this.morningSession = morningSession;
        this.afternoonSession = afternoonSession;
        this.lunchStartTime = lunch_start_time; // ToDo: this is a non-standard format for a java variable name
    }

    /**
     * @param morning_session
     * @param afternoon_session
     * @param lunchStartTime
     * @param nextwork_start_time
     * @param start_time
     */
    // TODO: this could call the other constructor
    public Track(String name) {

        afternoonStartTime = LocalTime.parse("13:00");
        morningStartTime = LocalTime.parse("09:00");
        this.morningSession = new Session(morningStartTime);
        this.afternoonSession = new Session(afternoonStartTime);
        this.lunchStartTime = LocalTime.parse("12:00");
        this.name = name;
    }

    /**
     * @return the morning_session
     */
    public Session getMorning_session() {
        return morningSession;
    }


    /**
     * @return the afternoon_session
     */
    public Session getAfternoon_session() {
        return afternoonSession;
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
    public LocalTime getStart_time() {
        return morningSession.getSessionStartTime();
    }


    /**
     * @return the total track length without the network event
     */
    // TODO: rename getTotalTalksDuration (note the pulral "Talks")
    public double getTotalTalkTime() {

        double morning_length = morningSession.getSessionLength();
        double afternoon_length = afternoonSession.getSessionLength();
        return morning_length + afternoon_length;

    }

    @Override
    public String toString() {
        
        String output = name + "\n";
        for(Talk talk: morningSession.getTalkList()){
            output += talk.toString() + "\n";
        }
        output += lunchStartTime + " Lunch Time \n";
        for (Talk talk : afternoonSession.getTalkList()) {
            output += talk.toString()+ "\n";
        }
        output += getNetworkEventStartTime() + " Network Event \n";;
        return output;
    }

    //. TODO: move thsi above the toString, and add Javadoc
    public LocalTime getNetworkEventStartTime() {

        double endtime = afternoonSession.getSessionLength();
        if (endtime <= 180) {
            return networkEventStartTime;
        } else {
            return networkEventStartTime.plusMinutes(60);
        }

    }



}
