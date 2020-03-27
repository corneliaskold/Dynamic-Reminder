package Model;

/**
 * Timespan sets the intervalls beetween how often a task needs to be done.
 * @author Hanna Ringkvist
 * @version 1.0
 */

public class TimeSpan {
    private int time;
    private TimeUnit timeUnit;

    public TimeSpan(int time, TimeUnit timeUnit){
        this.time = time;
        this.timeUnit = timeUnit;
    }


    public int getInHours(){
        return 0;
        //TODO
    }

    public int getTime(){
        return time;
    }

    public void setTime(int time){
        this.time = time;
    }

    public TimeUnit getTimeUnit(){
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit){
        this.timeUnit = timeUnit;
    }

    public String toString(){
        return "";

        //TODO
    }
}
