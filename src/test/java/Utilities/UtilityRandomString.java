package Utilities;

import Resources.ConfigurationManager;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.lang3.RandomStringUtils;

public class UtilityRandomString {

    public static String getRandomString() {
        ConfigurationManager config = ConfigFactory.create(ConfigurationManager.class);
        return RandomStringUtils.randomAlphanumeric(config.length());
    }

}
