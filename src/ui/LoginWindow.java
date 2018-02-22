package ui;

import helpers.GuiHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginWindow {

    private boolean isLoggedIn = false;
    JFrame loginFrame;

    public void startup() {
        JFrame loginFrame = new JFrame("Login");
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.CENTER);
        loginFrame.setLayout(layout);
        loginFrame.setSize(500, 200);

        JLabel userLabel = new JLabel("Username");
        JLabel passwLabel = new JLabel("Password");
        JLabel domainLabel = new JLabel("Domain");
        JLabel controlLabel = new JLabel("Domain Controller");

        JTextField userText = new JTextField(20);
        JPasswordField passwText = new JPasswordField(20);
        JTextField domainText = new JTextField(20);
        JTextField controlText = new JTextField(20);

        JButton loginButton = new JButton("Log in");
        JButton quitButton = new JButton("Quit");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwLabel);
        panel.add(passwText);
        panel.add(domainLabel);
        panel.add(domainText);
        panel.add(controlLabel);
        panel.add(controlText);
        panel.add(loginButton);
        panel.add(quitButton);

        loginFrame.add(panel);
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = "";
                for (int i = 0; i < passwText.getPassword().length; i++) {
                    char p = passwText.getPassword()[i];
                    password += p;
                }
                String domain = domainText.getText();
                String controller = controlText.getText();
                GuiHelper guiHelper = new GuiHelper();
                try {
                    guiHelper.login(username, password, domain, controller);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                isLoggedIn = true;
                JOptionPane.showMessageDialog(loginFrame, "Correctly logged in");
                loginFrame.dispose();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container frame = quitButton.getParent();
                do
                    frame = frame.getParent();
                while (!(frame instanceof JFrame));
                ((JFrame) frame).dispose();
            }
        });

        loginFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                JFrame frame;
                try {
                    if (!isLoggedIn) {
                        frame = MainFrame.getFrame();
                        frame.dispose();
                    } else {
                        MainFrame.getMain().setLoggedIn(true);
                        MainFrame.getMain().init();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }
}
