package sd.co.uk.domain;

import sd.co.uk.util.TalkDuration;

public class Talk {

    private String title;
    private TalkDuration duration;

    // TODO: there are fixed options for talk durations right? You could make an enum of them and
    // embed it in this class (which then makes this more type-safe and descriptive)
    // TODO: you could then encapsulate the types of talk (Lightning and normal or whatever its
    // called in the types, which will read really nicely)

    /**
     * @param duration
     * @param title
     */
    public Talk(String title, TalkDuration duration) {
        if (title.isEmpty() || title == null) {
            throw new IllegalArgumentException("Title can't be null or empty");
        } else {
            this.title = title;
        }
        this.duration = duration;

    }

    /**
     * @return the duration
     */
    public TalkDuration getDuration() {
        return duration;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
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
        result = prime * result + duration.getTalkDurationAsInt();
        result = prime * result + ((title == null) ? 0 : title.hashCode());
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
        Talk other = (Talk) obj;
        if (duration != other.duration)
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }



}

