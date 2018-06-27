package sd.co.uk.util;

public enum TalkDuration {

    LIGHTING (5),
    FIFTEEN_MINS(15),
    THIRTY_MINS(30),
    FORTY_FIVE_MINS(45),
    SIXTY_MIN(60);

    private final int talkDuration;

    private TalkDuration(int talkDuration) {
        this.talkDuration = talkDuration;
    }

    /**
     * @return the talkDuration
     */
    public int getTalkDurationAsInt() {
        return talkDuration;
    }

}
