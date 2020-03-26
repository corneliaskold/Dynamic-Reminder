package Model;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Keeps track o a intervall with a startTime, from and a endtime, to
 * @author Hanna My Jansson
 * @version 1.0
 */
public class TimeInterval {
    private LocalTime from;
    private LocalTime to;
    private boolean isEmpty;


    public TimeInterval(LocalTime from, LocalTime to) {
        this.from = from;
        this.to = to;
        isEmpty = false;
    }

    public TimeInterval() {
        isEmpty = true;
    }


    /**
     * Checks if the interval is empty
     * @return true if ther is no specified time in the interval
     */
    public boolean isEmpty() {
        return isEmpty;
    }


    /**
     * Changes the interval to the given parameters from och to.
     * @param from the beginning of the interval
     * @param to the end of the interval
     * @return true if it was able to change the interval
     */
    public boolean setInterval(LocalTime from, LocalTime to) {
        if (from.isBefore(to)) {
            this.from = from;
            this.to = to;
            isEmpty = false;
            return true;
        } else {
            return false;
        }

    }

    /**
     * Checks if the date is in the interval
     * @param date the date to be checked
     * @return true if the given date is in the given time Interval
     */
    public boolean isInInterval(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);

        LocalTime testTime = LocalTime.of(hour, minute);

        if (testTime.isBefore(to) && testTime.isAfter(from)) {
            return true;
        }
        return false;
    }
}
