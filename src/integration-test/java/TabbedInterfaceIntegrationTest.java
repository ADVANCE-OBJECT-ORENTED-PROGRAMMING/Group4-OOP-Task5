import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import static org.junit.jupiter.api.Assertions.*;

public class TabbedInterfaceIntegrationTest {

    private JTabbedPane tabs;

    @BeforeEach
    public void setUp() {
        TabbedInterfaceDemo demo = new TabbedInterfaceDemo();
        tabs = new JTabbedPane();
        tabs.add("User Info", demo.createUserInfoPanel());
        tabs.add("Settings", demo.createSettingsPanel());
        tabs.add("Statistics", demo.createStatisticsPanel());
        tabs.add("Messages", demo.createMessagesPanel());
        tabs.add("Help", demo.createHelpPanel());
    }

    @Test
    public void testTabCountAndTitles() {
        assertEquals(5, tabs.getTabCount());
        assertEquals("User Info", tabs.getTitleAt(0));
        assertEquals("Settings", tabs.getTitleAt(1));
        assertEquals("Statistics", tabs.getTitleAt(2));
        assertEquals("Messages", tabs.getTitleAt(3));
        assertEquals("Help", tabs.getTitleAt(4));
    }

    @Test
    public void testAllTabsContainPanels() {
        for (int i = 0; i < tabs.getTabCount(); i++) {
            assertTrue(tabs.getComponentAt(i) instanceof JPanel);
        }
    }
}
