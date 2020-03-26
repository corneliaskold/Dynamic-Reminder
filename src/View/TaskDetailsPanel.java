package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.*;
import Model.TimeUnit;

/**
 * @author Cornelia Sköld & Hanna My Jansson
 * @version 1.0
 */
public class TaskDetailsPanel extends JPanel{
    private int width, height;
    private Controller controller;
    private JScrollPane scrollPane;

    //task title
    private JPanel titlePanel;
    private JLabel lblTitle;
    private JTextField tfTitle;

    //task interval
    private JPanel intervalPanel;
    private JLabel lblIntervalChoice;
    private JTextField tfInterval;
    private JComboBox comboBoxTimeUnits;

    //possible time
    private JLabel lblPossibleTime;
    private JPanel possibleHoursPanel;
    private JLabel lblHoursFrom;
    private JLabel lblHoursTo;
    private JComboBox comboBoxHoursFrom;
    private JComboBox comboBoxHoursTo;
    private JButton btnAddHourInterval;

    private JPanel weekdaysPanel;
    private JLabel lblWeekdayPanel;
    private JCheckBox cbMonday, cbTuesday, cbWednesday, cbThursday, cbFriday, cbSaturday, cbSunday;

    private JPanel datesPanel;
    private JLabel lblDates;
    private JTextField tfDates;

    //notes
    private JLabel lblNotes;
    private JTextArea taNotes;

    //save
    private JPanel savePanel;
    private JButton btnSave;

    private JPanel panel;
    private JLabel emptyLabel = new JLabel(" ");

    public TaskDetailsPanel(Controller controller, int width, int height) {
        this.controller = controller;
        this.width = width;
        this.height = height;

        setPreferredSize(new Dimension(width, height));
        //Scroll pane panels size:
        Dimension dim = new Dimension((width - 30), 25);

        //Task title panel
        lblTitle = new JLabel("  I would like to be reminded to...");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 14));
        titlePanel = new JPanel();
        tfTitle = new JTextField();
        tfTitle.setPreferredSize(new Dimension((width - 25), 25));
        titlePanel.add(tfTitle);

        // Task interval panel
        intervalPanel = new JPanel();
        lblIntervalChoice = new JLabel("I would like to do this every");
        lblIntervalChoice.setFont(new Font("Arial", Font.BOLD, 14));
        lblIntervalChoice.setPreferredSize(new Dimension(200, 25));
        tfInterval = new JTextField();
        tfInterval.setPreferredSize(new Dimension(40, 25));
        //String timeUnits[] = {"hour", "day", "week", "month", "year"};
        //comboBoxTimeUnits = new JComboBox(timeUnits);
        comboBoxTimeUnits = new JComboBox(TimeUnit.values());
        intervalPanel.add(lblIntervalChoice);
        intervalPanel.add(tfInterval);
        intervalPanel.add(comboBoxTimeUnits);

        //Possible time for execution
        lblPossibleTime = new JLabel("  I am available for this task:");
        lblPossibleTime.setFont(new Font("Arial", Font.BOLD, 14));

        possibleHoursPanel = new JPanel();
        lblHoursFrom = new JLabel("Hours from:");
        lblHoursTo = new JLabel("To:");
        String hours[] = {"01","02","03","04","05","06","07","08","09","10","11","12",
                "13","14","15","16","17","18","19","20","21","22","23","24"};
        comboBoxHoursFrom = new JComboBox(hours);
        comboBoxHoursTo = new JComboBox(hours);
        btnAddHourInterval = new JButton("Add");
        possibleHoursPanel.add(lblHoursFrom);
        possibleHoursPanel.add(comboBoxHoursFrom);
        possibleHoursPanel.add(lblHoursTo);
        possibleHoursPanel.add(comboBoxHoursTo);
        possibleHoursPanel.add(btnAddHourInterval);

        lblWeekdayPanel = new JLabel("  Weekdays:");
        lblWeekdayPanel.setFont(new Font("Arial", Font.BOLD, 14));

        weekdaysPanel = new JPanel(new GridLayout(2, 4));
        cbMonday = new JCheckBox("Monday");
        cbTuesday = new JCheckBox("Tuesday");
        cbWednesday = new JCheckBox("Wednesday");
        cbThursday = new JCheckBox("Thursday");
        cbFriday = new JCheckBox("Friday");
        cbSaturday = new JCheckBox("Saturday");
        cbSunday = new JCheckBox("Sunday");

        weekdaysPanel.add(cbMonday);
        weekdaysPanel.add(cbTuesday);
        weekdaysPanel.add(cbWednesday);
        weekdaysPanel.add(cbThursday);
        weekdaysPanel.add(cbFriday);
        weekdaysPanel.add(cbSaturday);
        weekdaysPanel.add(cbSunday);

        datesPanel= new JPanel();
        lblDates = new JLabel("Specific date:");
        lblDates.setFont(new Font("Arial", Font.BOLD, 14));
        tfDates = new JTextField("YYMMDD");
        datesPanel.add(lblDates);
        datesPanel.add(tfDates);

        //Notes
        lblNotes = new JLabel("  Notes:");
        lblNotes.setFont(new Font("Arial", Font.BOLD, 14));
        taNotes = new JTextArea();

        savePanel = new JPanel();
        btnSave = new JButton("Save task!");
        btnSave.addActionListener(new ButtonActionListener());
        savePanel.add(btnSave);

        panel = new JPanel(new GridLayout(18, 1));
        panel.setPreferredSize(new Dimension(width - 30, height));
        panel.add(lblTitle);
        panel.add(titlePanel);
        panel.add(emptyLabel);
        panel.add(intervalPanel);
        panel.add(emptyLabel);
        panel.add(lblPossibleTime);
        panel.add(possibleHoursPanel);
        panel.add(emptyLabel);
        panel.add(lblWeekdayPanel);
        panel.add(weekdaysPanel);
        panel.add(datesPanel);
        panel.add(emptyLabel);
        panel.add(lblNotes);
        panel.add(taNotes);
        panel.add(emptyLabel);
        panel.add(savePanel);

        scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(width, height));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);

    }


    public String getTitle(){
        return tfTitle.getText();
    }

    public String getInfo(){
        return taNotes.getText();
    }

    public int getIntervalAmount(){
        int interval = 0;
        interval = Integer.parseInt(tfInterval.getText());
        return interval;
    }

    public TimeUnit getIntervalUnit(){
        //TODO funkar detta? eller är det en string som ska göras om till en timeunit först?
        TimeUnit timeUnit = (TimeUnit) comboBoxTimeUnits.getSelectedItem();
        return timeUnit;
    }
    private class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnSave) {
                controller.buttonPressed(ButtonType.SAVE);
            }
        }
    }
}
