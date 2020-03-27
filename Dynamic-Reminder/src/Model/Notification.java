package Model;

import java.util.Date;

/**
 * This class represents a notification
 * @author Minna Röriksson
 * @version 1.0
 */
public class Notification {
    private Task task;
    private Date timeForNotification;
    private String message;
    private String buttonTitles;

    public Notification(Task task, Date timeForNotification, String message, String buttonTitles){
        this.task = task;
        this.timeForNotification = timeForNotification;
        this.message = message;
        this.buttonTitles = buttonTitles;
    }

    public void setTimeForNotification(Date timeForNotification){
        this.timeForNotification = timeForNotification;
    }

    public Date getTimeForNotification() {
        return timeForNotification;
    }

    public int getNbrOfButtons(){
        return 0;
    }

    public String getButtonText(int nbrOfButtons){
        return null;
    }

}
