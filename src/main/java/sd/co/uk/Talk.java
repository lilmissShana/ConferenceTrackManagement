package sd.co.uk; // todo: move to a ".domain" package

import java.time.LocalTime;

public class Talk {

    // TODO: Rename this to duration (more time-y)
    private int length;
    private LocalTime startTime;
    private String title; // todo: move to the top of the args list

    // TODO: there are fixed options for talk durations right? You could make an enum of them and embed it in this class (which then makes this more type-safe and descriptive)
    // TODO: you could then encapsulate the types of talk (Lightning and normal or whatever its called in the types, which will read really nicely)

    /**
     * @param length
     * @param title
     */
    public Talk(String title, int length) {
        // TODO: nullcheck here so that you can't pass in an empty title, and also check that length isn't less than or equal to zero
        this.length = length; // todo: put these in the same order as the args to the constructur
        this.title = title;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the startTime
     */
    // TODO: extend Talk to ceate a ScheduledTalk which just wraps Talk and adds a startTime (and has a convenience method to return an endTime (if needed)
    public LocalTime getStartTime() {
        if (null == startTime) {
            return null;
        }
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }


    @Override
    public String toString() {

        return this.startTime + " " + this.title + " " + this.length + "min";
    }

    // TODO: create hashcode and equals

}

