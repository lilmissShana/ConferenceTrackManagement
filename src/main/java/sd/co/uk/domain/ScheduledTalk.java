package sd.co.uk.domain;

import java.time.LocalTime;

import sd.co.uk.util.TalkDuration;

public final class ScheduledTalk extends Talk {

    private LocalTime startTime;


    /**
     * @param talkTime
     */
    public ScheduledTalk(String title, TalkDuration duration, LocalTime startTime) {
        super(title, duration);
        this.startTime = startTime;
    }


    /**
     * @return the startTime
     */
    public LocalTime getStartTime() {
        if (null == startTime) {
            return null;
        }
        return startTime;
    }

    /**
     * @return the end time of a talk
     */
    public LocalTime getEndTime() {
        
        LocalTime endTime = this.startTime.plusMinutes(getduration().getTalkDurationAsInt());
        return endTime;
    }


    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return startTime + " " + getTitle();
        
    }


    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
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
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ScheduledTalk other = (ScheduledTalk) obj;
        if (startTime == null) {
            if (other.startTime != null)
                return false;
        } else if (!startTime.equals(other.startTime))
            return false;
        return true;
    }



}




