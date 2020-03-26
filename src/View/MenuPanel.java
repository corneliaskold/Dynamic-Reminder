package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.*;

/**
 * @author Cornelia Sköld & Hanna My Jansson
 * @version 1.0
 */
public class MenuPanel extends JPanel{
    private JButton btnAdd, btnDelete, btnTasks, btnCalendar, btnStatistics;
    private Controller controller;

    public MenuPanel(Controller controller, int width, int height){
        this.controller = controller;
        setPreferredSize(new Dimension(width, height));
        setLayout(new GridLayout(1,5));

        btnTasks = new JButton("Tasks");
        btnAdd = new JButton("Add");
        btnDelete = new JButton("Delete");
        btnCalendar = new JButton("Calendar");
        btnStatistics = new JButton("Stats");

        add(btnTasks);
        add(btnAdd);
        add(btnDelete);
        add(btnCalendar);
        add(btnStatistics);
        addListeners();
    }

    public void addListeners(){
        ActionListener listener = new ButtonActionListener();
        btnTasks.addActionListener(listener);
        btnAdd.addActionListener(listener);
        btnDelete.addActionListener(listener);
        btnCalendar.addActionListener(listener);
        btnStatistics.addActionListener(listener);
    }

    class ButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnAdd) {
                controller.buttonPressed(ButtonType.TASKS);
            } else if (e.getSource() == btnTasks){
                controller.buttonPressed(ButtonType.ADD);
            } else if (e.getSource() == btnDelete){
                controller.buttonPressed(ButtonType.DELETE);
            } else if (e.getSource() == btnCalendar){
                controller.buttonPressed(ButtonType.CALENDAR);
            } else if (e.getSource() == btnStatistics){
                controller.buttonPressed(ButtonType.STATISTICS);
            }
        }
    }
}
