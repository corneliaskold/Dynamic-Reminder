package Model;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Stores the hours possible, for a task to be done, in an array.
 * @author Hanna My Jansson
 * @version 1.0
 */
public class PossibleHours {
    private boolean whenever;
    private TimeInterval[] intervals;
    private int freeIntervalIndex;
    private static final int MAX_NBR_OF_INTERVALS = 10;

    public PossibleHours() {
        intervals = new TimeInterval[MAX_NBR_OF_INTERVALS];
        whenever = true;
        freeIntervalIndex = 0;
    }

    /**
     * Adds a interval to the array of intervals
     * @param from, the beginning of the interval
     * @param to, object then end of the interval
     * @return true if it added the interval, otherwise false.
     */
    public boolean addInterval(Date from, Date to) {

        if (freeIntervalIndex >= MAX_NBR_OF_INTERVALS)
            return false;


        Calendar cal = Calendar.getInstance();
        cal.setTime(from);
        int fromHour = cal.get(Calendar.HOUR);
        int fromMinute = cal.get(Calendar.MINUTE);
        LocalTime timeFrom = LocalTime.of(fromHour, fromMinute);

        cal.setTime(to);
        int toHour = cal.get(Calendar.HOUR);
        int toMinute = cal.get(Calendar.HOUR);
        LocalTime timeTo = LocalTime.of(toHour, toMinute);

        intervals[freeIntervalIndex].setInterval(timeFrom, timeTo);

        whenever = false;
        return true;

    }

    /**
     * Adds a interval to the array of intervals
     * @param timeFrom the beginning of the interval
     * @param timeTo object then end of the interval
     * @return true if it was able to add the interval
     */
    public boolean addInterval(LocalTime timeFrom, LocalTime timeTo) {

        if (freeIntervalIndex >= MAX_NBR_OF_INTERVALS)
            return false;

        intervals[freeIntervalIndex].setInterval(timeFrom, timeTo);

        whenever = false;
        return true;

    }

    /**
     * Deletes all intervals in the array
     */
    public void clearAllInterval() {
        for (int i=0; i<intervals.length;i++){
            intervals[i] = new TimeInterval();
        }
        whenever = true;
    }


    /**
     * Checks if the date is possible
     * @param date the date to be checked
     * @return true if its possible
     */
    public boolean possible(Date date) {
        if (whenever)
            return true;

        boolean possible = false;

        for (TimeInterval interval : intervals) {
            if (interval.isInInterval(date))
                possible = true;
        }
        return possible;
    }
}
