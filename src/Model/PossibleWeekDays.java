package Model;

import java.util.Calendar;
import java.util.Date;

/**
 * Stores the weekdays possible, for a task to be done, in an array.
 * @author Hanna My Jansson
 * @version 1.0
 */
public class PossibleWeekDays {
    private boolean[] possibleWeekdays;

    public PossibleWeekDays() {
        possibleWeekdays = new boolean[7];
        setAllTrue();
    }


    /**
     *sets all the booleans in the array to true
     */

    public void setAllTrue(){
        for(int i = 0; i< possibleWeekdays.length; i++){
            possibleWeekdays[i] = true;
        }
    }


    /**
     * Sets the possible weeksDays
     * @param possibleWeekdays
     */
    public void setPossibleWeekdays(boolean[] possibleWeekdays) {
        this.possibleWeekdays = possibleWeekdays;
    }

    /**
     * Returns true if the task is possible to do whenever
     * @return boolean, true if it is possible
     */

    public boolean possibleWhenever(){
        if(possibleWeekdays[0]&& possibleWeekdays[1]&& possibleWeekdays[2]&& possibleWeekdays[3]&& possibleWeekdays[4]&& possibleWeekdays[5]&& possibleWeekdays[6])
            return true;
        else
            return false;
    }

    /**
     * Checks if the task is possible to perform at the given date
     * @param date, the date that we want to preform the task at
     * @return true if the task is possible to perform at the given date
     */

    public boolean possible(Date date){
        if(possibleWhenever())
            return true;

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int weekday = cal.get(Calendar.DAY_OF_WEEK);
        if (possibleWeekdays[weekday-1])
            return true;

        return false;
    }
}
