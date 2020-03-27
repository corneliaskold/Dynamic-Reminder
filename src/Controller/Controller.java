package Controller;

import java.util.Calendar;
import java.util.Date;
import View.MainFrame;
import View.ButtonType;
import Model.*;
//hej intellij
//hejsan
/**
 * @author Hanna My Jansson
 * @version 1.0
 */
public class Controller {
    private MainFrame frame;
    private TaskRegister taskRegister;

    public Controller() {
        frame = new MainFrame(this);
        taskRegister = new TaskRegister();
    }


    public void buttonPressed(ButtonType button) {
        switch (button) {
            case TASKS:
                frame.setCard("2"); //TODO: ta reda p� varf�r 2 visar overview
                break;
            case ADD:
                frame.setCard("1"); //TODO: ta reda p� varf�r 1 visar add

                break;
            case DELETE:
                //frame.setCard("3");
                break;
            case CALENDAR:
                //frame.setCard("4");
                break;
            case STATISTICS:
                //frame.setCard("5");
                Calendar cal = Calendar.getInstance();
                Date dateNow = cal.getTime();

                break;

            case MARKASDONE:



                break;
            case SAVE:

                String title = frame.getTitle();
                String info = frame.getInfo();
                int intervalAmount = frame.getIntervalAmount();
                TimeUnit timeUnit = frame.getIntervalUnit();
                TimeSpan preferredInterval = new TimeSpan(intervalAmount, timeUnit);
                Task newTask = new Task(title, info, preferredInterval);
                taskRegister.addTask(newTask);
                frame.addTask(newTask.getTitle(), newTask.getTimeUntil(), newTask.getTimeUnit());
                frame.setCard("2");
                break;
        }


    }

    private void updateGUI(){

    }
    public static void main(String[] args) {
        Controller controller = new Controller();
    }
}
