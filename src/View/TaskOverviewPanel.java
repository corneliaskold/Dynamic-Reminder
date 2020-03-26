package View;

import javax.swing.*;
import java.awt.*;
import Controller.*;
import Model.TimeUnit;

/**
 * @author Cornelia Sköld & Hanna My Jansson
 * @version 1.0
 */
public class TaskOverviewPanel extends JPanel{
    private int width, height;
    private Controller controller;

    private SingleTaskPanel[] singleTaskPanels;
    private int index;


    public TaskOverviewPanel(Controller controller, int width, int height) {
        this.controller = controller;
        this.width = width;
        this.height = height;
        singleTaskPanels = new SingleTaskPanel[30];
        index = 0;
        setPreferredSize(new Dimension(width, height));


    }

    public void addTask(String title, int timeRemaining, TimeUnit timeUnit) {

        singleTaskPanels[index] = new SingleTaskPanel(title, timeRemaining, timeUnit);
        add(singleTaskPanels[index]);
        index++;
    }
}
