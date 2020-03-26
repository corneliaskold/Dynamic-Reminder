package View;

import javax.swing.*;
import java.awt.*;
import Controller.*;
import Model.TimeUnit;

/**
 * @author Cornelia Sköld & Hanna My Jansson
 * @version 1.0
 */
public class MainFrame extends JFrame {
    private int width = 350;
    private int height = 700;
    private MainPanel panel;
    private Controller controller;

    public MainFrame(Controller controller) {
        this.controller = controller;

        final int offsetX = width;
        final int offsetY = height / 10;
        setLocation(offsetX, offsetY);

        setSize(new Dimension(width, height));
        setTitle("Dynamic Reminder");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new MainPanel(controller, width, height);
        setContentPane(panel);
        pack();
        setVisible(true);
    }
    public void setCard(String cardNbr){
        panel.setCard(cardNbr);
    }


    public String getTitle(){
        return panel.getTaskDetailsPanel().getTitle();
    }

    public String getInfo(){
        return panel.getTaskDetailsPanel().getInfo();
    }

    public int getIntervalAmount(){
        return panel.getTaskDetailsPanel().getIntervalAmount();
    }

    public TimeUnit getIntervalUnit(){
        return panel.getTaskDetailsPanel().getIntervalUnit();
    }

    public void addTask(String title, int timeRemaining, TimeUnit timeUnit){
        panel.getTaskOverviewPanel().addTask(title,timeRemaining, timeUnit);
    }
}
