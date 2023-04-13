package Resources;

import org.aeonbits.owner.Config;

import java.util.ArrayList;

@Config.Sources({"file:src/test/java/Resources/general.properties"})
public interface ConfigurationManager extends Config {

    @Config.Key("url.base")
    String url();

    @Config.Key("chromeOptions")
    ArrayList<String> chromeOptions();

    @Config.Key("timeout")
    int timeout();

    @Config.Key("browser")
    String browser();

    @Config.Key("randomStringLength")
    int length();

    @Config.Key("InitialScreenResolution")
    int InitialScreenResolution();

    @Config.Key("NeededScreenResolution")
    int NeededScreenResolution();

    @Config.Key("numOfMaxWindows")
    int numOfMaxWindows();

}
