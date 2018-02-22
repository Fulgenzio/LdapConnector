package ui;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.TOP;

public class MainFrame {

    private static MainFrame mainFrame;
    private static JFrame frame;
    private boolean isLoggedIn = false;

    public static MainFrame getMain() throws Exception
    {
        if (mainFrame == null)
            mainFrame = new MainFrame();

        return mainFrame;
    }

    public static JFrame getFrame() throws Exception {
        if(frame == null) {
            MainFrame mf = MainFrame.getMain();
            frame = mainFrame.startup();
        }
        return frame;
    }

    public JFrame startup() {

        frame = new JFrame("Active Directory Operator");
        frame.setSize(800, 600);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        if(!isLoggedIn) {
            LoginWindow window = new LoginWindow();
            window.startup();
        }

        return frame;
    }

    public void init() {
        try {
            frame = getFrame();

            JTabbedPane mainTabs = new JTabbedPane(TOP);

            JPanel exportTab = createTabPanel("Export");
            JPanel changePwdTab = createTabPanel("Change Password");

            mainTabs.addTab("Export", exportTab);
            mainTabs.addTab("Change Password", changePwdTab);
            mainTabs.setLayout(new GridLayout(2,2));
            frame.add(mainTabs);
            mainTabs.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    JPanel createTabPanel(String text) {
        JPanel tabPanel = new JPanel();
        JLabel tabLabel = new JLabel(text);
        tabLabel.setHorizontalAlignment(JLabel.CENTER);
        tabPanel.setLayout(new GridLayout(1, 1));
        tabPanel.add(tabLabel);
        return tabPanel;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
