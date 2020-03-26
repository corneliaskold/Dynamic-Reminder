package Model;

import java.time.LocalTime;
import java.util.Date;

/**
 * Stores the dates, hours and weekdays possible, for a task to be done, in an array.
 * @author Hanna My Jansson
 * @version 1.0
 */
public class PossibleTime {
    private PossibleHours possibleHours;
    private PossibleDates possibleDates;
    private  PossibleWeekDays possibleWeekDays;


    public PossibleTime() {
        possibleDates = new PossibleDates();
        possibleHours = new PossibleHours();
        possibleWeekDays = new PossibleWeekDays();
    }

    /**
     * Sets the possible dates to the values int the array sent in the parameters.
     * @param possibleDates
     */
    public void setPossibleDates(boolean[] possibleDates) {
        this.possibleDates.setPossibleDates(possibleDates);
    }

    /**
     * sets the possible hours to the interval derived from the two date objects
     * clears all intervals from before
     * @param from a Date with the right time for the beginning of the interval
     * @param to a Date with the right time for the end of the interval
     */
    public void setPossibleHours(Date from, Date to) {
        possibleHours.clearAllInterval();
        possibleHours.addInterval(from, to);
    }

    /**
     * sets the possible hours to the interval with the help of two LocalTime Objects
     * clears all intervals from before
     * @param from a LocalTime with the right time for the beginning of the interval
     * @param to a LocalTime with the right time for the end of the interval
     */
    public void setPossibleHours(LocalTime from, LocalTime to) {
        possibleHours.clearAllInterval();
        possibleHours.addInterval(from, to);
    }

    /**
     * Adds a new interval to the list of possibleTimes
     * @param from a LocalTime with the right time for the beginning of the interval
     * @param to a LocalTime with the right time for the end of the interval
     */
    public boolean addPossibleHours(LocalTime from, LocalTime to) {
        boolean worked = possibleHours.addInterval(from, to);
        return worked;
    }

    /**
     * sets the possible weekdays
     * @param possibleWeekDays a array with booleans representing the possibility to do the task that day. weekday-1 = index. example: tuesday= index 1.
     */
    public void setPossibleWeekDays(boolean[] possibleWeekDays) {
        this.possibleWeekDays.setPossibleWeekdays(possibleWeekDays);
    }

    /**
     *
     * @param date
     * @return
     */
    public boolean possible(Date date){
        return ( possibleWeekDays.possible(date)  &&  possibleDates.possible(date)  &&   possibleHours.possible(date) );
    }
}
