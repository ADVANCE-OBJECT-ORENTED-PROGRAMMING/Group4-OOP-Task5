import javax.swing.*;
import java.awt.*;

public class TabbedInterfaceDemo extends JFrame {

    public TabbedInterfaceDemo() {
        this.setTitle("Tabbed Interface Demo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);


        // Create tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add tabs
        tabbedPane.addTab("User Info", createUserInfoPanel());
        tabbedPane.addTab("Settings", createSettingsPanel());
        tabbedPane.addTab("Statistics", createStatisticsPanel());
        tabbedPane.addTab("Messages", createMessagesPanel());
        tabbedPane.addTab("Help", createHelpPanel());

        this.add(tabbedPane);
        this.setVisible(true);
    }

    // Tab 1: User Info (text fields and labels)
    public JPanel createUserInfoPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("First Name:"));
        panel.add(new JTextField());

        panel.add(new JLabel("Last Name:"));
        panel.add(new JTextField());

        panel.add(new JLabel("Email:"));
        panel.add(new JTextField());

        panel.add(new JLabel("Phone Number:"));
        panel.add(new JTextField());

        return panel;
    }

    // Tab 2: Settings (checkboxes and combo box)
    public JPanel createSettingsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JCheckBox notificationsCheck = new JCheckBox("Enable Notifications");
        JCheckBox darkModeCheck = new JCheckBox("Dark Mode");
        JCheckBox autoUpdateCheck = new JCheckBox("Enable Auto Update");

        panel.add(notificationsCheck);
        panel.add(darkModeCheck);
        panel.add(autoUpdateCheck);

        return panel;
    }


    // Tab 3: Statistics (labels and progress bars)
    public JPanel createStatisticsPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("CPU Usage:"));
        JProgressBar cpuBar = new JProgressBar(0, 100);
        cpuBar.setValue(65);
        cpuBar.setStringPainted(true);
        panel.add(cpuBar);

        panel.add(new JLabel("Memory Usage:"));
        JProgressBar memoryBar = new JProgressBar(0, 100);
        memoryBar.setValue(40);
        memoryBar.setStringPainted(true);
        panel.add(memoryBar);

        panel.add(new JLabel("Disk Usage:"));
        JProgressBar diskBar = new JProgressBar(0, 100);
        diskBar.setValue(75);
        diskBar.setStringPainted(true);
        panel.add(diskBar);

        return panel;
    }

}
