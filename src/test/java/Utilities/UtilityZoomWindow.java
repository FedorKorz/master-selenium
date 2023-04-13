package Utilities;

import Resources.ConfigurationManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.awt.event.KeyEvent;

public class UtilityZoomWindow {

    private static Logger logger = LoggerObject.getLogger();
    private static ConfigurationManager config = UtilityConfig.getConfig();

    public static void ZoomOut() {

        int NeededScreenResolution = config.NeededScreenResolution();
        int InitialScreenResolution = config.InitialScreenResolution();

        try {
            Robot robot = new Robot();
            while (InitialScreenResolution > NeededScreenResolution) {
                InitialScreenResolution = InitialScreenResolution - 10;
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_SUBTRACT);
                robot.keyRelease(KeyEvent.VK_SUBTRACT);
                robot.keyRelease(KeyEvent.VK_CONTROL);
            }
        } catch (AWTException ex) {
            logger.info("Abstract Window Toolkit exception has occurred");
        }
    }
}
