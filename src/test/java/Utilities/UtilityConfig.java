package Utilities;

import Resources.ConfigurationManager;
import org.aeonbits.owner.ConfigFactory;

public class UtilityConfig {
    public static ConfigurationManager getConfig() {
        return ConfigFactory.create(ConfigurationManager.class);
    }
}
