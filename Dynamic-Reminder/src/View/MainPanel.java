package View;

import javax.swing.*;
import java.awt.*;
import Controller.*;

/**
 * @author Cornelia Sköld & Hanna My Jansson
 * @version 1.0
 */
public class MainPanel extends JPanel{
    private int width;
    private int height;
    private JLabel lblTitle;
    private JPanel cardPanel;
    private TaskDetailsPanel taskDetailsPanel;
    private TaskOverviewPanel taskOverviewPanel;
    private CardLayout cardLayout;
    private MenuPanel menuPanel;
    private Controller controller;

    public MainPanel(Controller controller, int width, int height){ //TODO: Lägg till Controller som parameter
        this.controller = controller;
        this.width = width;
        this.height = height;

        setupPanel();
    }
    public void setupPanel(){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(width, height));

        JPanel titlePanel = new JPanel();
        int titleHeight = (int) (height * 0.06);
        titlePanel.setPreferredSize(new Dimension(width, titleHeight));
        titlePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        lblTitle = new JLabel("Tasks");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(lblTitle, BorderLayout.CENTER);
        add(titlePanel, BorderLayout.NORTH);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        int cardHeight = (int) (height * 0.86);
        taskOverviewPanel = new TaskOverviewPanel(controller, width, cardHeight);
        taskDetailsPanel = new TaskDetailsPanel(controller, width, cardHeight);
        //deletePanel = new DeletePanel(controller, width, cardHeight);
        //calendarPanel = new CalendarPanel(controller, width, cardHeight);
        //statisticsPanel = new StatisticsPanel(controller, width, cardHeight);
        cardPanel.add(taskOverviewPanel, "1");
        cardPanel.add(taskDetailsPanel, "2");
        //cardPanel.add(deletePanel, "3")
        //cardPanel.add(calendarPanel, "4");
        //cardPanel.add(statisticsPanel, "5");
        cardLayout.first(cardPanel);
        add(cardPanel, BorderLayout.CENTER);

        int menuHeight  = (int) (height * 0.08);
        menuPanel = new MenuPanel(controller, width, menuHeight);
        menuPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(menuPanel, BorderLayout.SOUTH);
    }

    public void setLblTitle(String title){
        lblTitle.setText(title);
    }

    public void setCard(String cardNbr){
        cardLayout.show(cardPanel, cardNbr);
    }

    public TaskOverviewPanel getTaskOverviewPanel() {
        return taskOverviewPanel;
    }

    public TaskDetailsPanel getTaskDetailsPanel() {
        return taskDetailsPanel;
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }
}
