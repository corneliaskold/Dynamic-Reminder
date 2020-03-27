package Model;

import java.util.Calendar;
import java.util.Date;

/**
 * This class represents a task .....
 * @author Anni Johansson
 * @version 1.0
 */
public class Task implements Comparable<Object>{
    private int id;     //TODO: Hur ger vi task ett id? Utifrån task-register?
    private String title;
    private String info;
    private TimeSpan preferredInterval;
    private TimeSpan maximum;
    private PossibleTime possibleTimeForExecution;
    private Date lastPerformed;
    private Notification nextNotification;

    public Task()
    {

    }

    public Task(int taskId)
    {
        id= taskId;
    }

    //TODO: Flera konstruktorer eller skicka in null och ?? i parametrarna när vissa val saknas?
    public Task(String title, String info, TimeSpan preferredInterval, TimeSpan maximum, PossibleTime possibleTimeForExecution)
    {
        this.title = title;
        this.info = info;
        this.preferredInterval = preferredInterval;
        this.maximum = maximum;
        this.possibleTimeForExecution = possibleTimeForExecution;
        markAsDoneNow();

    }
    public Task(String title, String info, TimeSpan preferredInterval)
    {
        this.title = title;
        this.info = info;
        this.preferredInterval = preferredInterval;
        markAsDoneNow();

    }

    public void performed(Date date)
    {

    }

    public void markAsDoneNow(){
        Calendar cal = Calendar.getInstance();
        Date dateNow = cal.getTime();
        lastPerformed = dateNow;
    }

    public Notification generateNotification()
    {
        return null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public TimeSpan getPreferredInterval() {
        return preferredInterval;
    }

    public void setPreferredInterval(TimeSpan preferredInterval) {
        this.preferredInterval = preferredInterval;
    }

    public TimeSpan getMaximum() {
        return maximum;
    }

    public void setMaximum(TimeSpan maximum) {
        this.maximum = maximum;
    }

    public PossibleTime getPossibleTimeForExecution() {
        return possibleTimeForExecution;
    }

    public void setPossibleTimeForExecution(PossibleTime possibleTimeForExecution) {
        this.possibleTimeForExecution = possibleTimeForExecution;
    }

    public Date getLastPerformed() {
        return lastPerformed;
    }

    public void setLastPerformed(Date lastPerformed) {
        this.lastPerformed = lastPerformed;
    }

    public Notification getNextNotification() {
        return nextNotification;
    }

    public void setNextNotification(Notification nextNotification) {
        this.nextNotification = nextNotification;
    }

    public int getTimeUntil(){
        int time = preferredInterval.getTime();
        int timeUntil = -5;
        if(lastPerformed == null){
            timeUntil = time;
        }else{
            timeUntil = time;
            //TODO
        }


        return timeUntil;
    }

    public TimeUnit getTimeUnit(){
        return preferredInterval.getTimeUnit();
    }

    public int getId() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int compareTo(Object o) {
        Task t = (Task) o;
        return Integer.compare(id,t.getId());
    }


}
