import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;

public class TabbedInterfaceDemoTest {

    private TabbedInterfaceDemo demo;

    @BeforeEach
    public void setUp() {
        demo = new TabbedInterfaceDemo();
    }

    @Test
    public void testCreateUserInfoPanel() {
        JPanel panel = demo.createUserInfoPanel();
        assertEquals(8, panel.getComponentCount(), "User Info panel should have 8 components (4 labels, 4 text fields)");

        Component[] components = panel.getComponents();
        for (int i = 0; i < components.length; i += 2) {
            assertInstanceOf(JLabel.class, components[i], "Expected JLabel at index " + i);
            assertInstanceOf(JTextField.class, components[i + 1], "Expected JTextField at index " + (i + 1));
        }
    }

    @Test
    public void testCreateSettingsPanel() {
        JPanel panel = demo.createSettingsPanel();
        assertEquals(3, panel.getComponentCount(), "Settings panel should have 3 checkboxes");

        Component[] components = panel.getComponents();
        for (Component c : components) {
            assertInstanceOf(JCheckBox.class, c, "Expected JCheckBox in settings panel");
        }
    }

    @Test
    public void testCreateStatisticsPanel() {
        JPanel panel = demo.createStatisticsPanel();
        assertEquals(6, panel.getComponentCount(), "Statistics panel should have 6 components (3 labels, 3 progress bars)");

        Component[] components = panel.getComponents();
        for (int i = 0; i < components.length; i += 2) {
            assertInstanceOf(JLabel.class, components[i], "Expected JLabel at index " + i);
            assertInstanceOf(JProgressBar.class, components[i + 1], "Expected JProgressBar at index " + (i + 1));
        }

        // Test progress values as example
        JProgressBar cpuBar = (JProgressBar) components[1];
        assertEquals(65, cpuBar.getValue());

        JProgressBar memoryBar = (JProgressBar) components[3];
        assertEquals(40, memoryBar.getValue());

        JProgressBar diskBar = (JProgressBar) components[5];
        assertEquals(75, diskBar.getValue());
    }

    @Test
    public void testCreateMessagesPanel() {
        JPanel panel = demo.createMessagesPanel();
        assertInstanceOf(BorderLayout.class, panel.getLayout(), "Messages panel should use BorderLayout");

        Component center = ((BorderLayout) panel.getLayout()).getLayoutComponent(panel, BorderLayout.CENTER);
        assertInstanceOf(JScrollPane.class, center, "Center component should be a JScrollPane");

        Component south = ((BorderLayout) panel.getLayout()).getLayoutComponent(panel, BorderLayout.SOUTH);
        assertInstanceOf(JPanel.class, south, "South component should be a JPanel");

        JPanel buttonPanel = (JPanel) south;
        assertEquals(2, buttonPanel.getComponentCount(), "Button panel should have 2 buttons");

        for (Component c : buttonPanel.getComponents()) {
            assertInstanceOf(JButton.class, c, "Expected JButton in the buttons panel");
        }
    }

    @Test
    public void testCreateHelpPanel() {
        JPanel panel = demo.createHelpPanel();
        assertInstanceOf(BorderLayout.class, panel.getLayout(), "Help panel should use BorderLayout");

        Component north = ((BorderLayout) panel.getLayout()).getLayoutComponent(panel, BorderLayout.NORTH);
        assertInstanceOf(JLabel.class, north, "North component should be a JLabel");

        JLabel label = (JLabel) north;
        String text = label.getText();
        assertTrue(text.contains("Help & Support"), "Help label text should contain heading");
        assertTrue(text.contains("<a href=''>website</a>"), "Help label should contain hyperlink html");
    }
}
