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

}
