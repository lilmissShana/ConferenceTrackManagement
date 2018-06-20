package sd.co.uk;

import java.time.LocalTime;

public class Talk {

    private int length;
    private LocalTime startTime;
    private String title;


    /**
     * @param length
     * @param title
     */
    public Talk(String title, int length) {
        this.length = length;
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



}

